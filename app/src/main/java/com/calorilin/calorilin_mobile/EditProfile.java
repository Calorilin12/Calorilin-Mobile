package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.user.UserData;
import com.calorilin.calorilin_mobile.model.userdetailspost.UserDetailPost;
import com.calorilin.calorilin_mobile.model.userpost.UserEdit;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {
    EditText username, email;
    ImageView fotoprofile;
    TextInputEditText password;
    String part_image;
    Button simpanProfile, backEP, editFoto;
    final int REQUEST_GALLERY = 9544;
    static boolean gambarawal = true;
    Uri dataimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");

        username = findViewById(R.id.editTextUsername);
        email = findViewById(R.id.editTextEmail);
        password = (TextInputEditText) findViewById(R.id.editTextPassword2);
        simpanProfile = findViewById(R.id.button_edit_profile);
        backEP = findViewById(R.id.backButtoneditprofile);
        fotoprofile = findViewById(R.id.foto_profil);
        editFoto = findViewById(R.id.button_edit_photo);

        backEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        editFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "open gallery"), REQUEST_GALLERY);
            }
        });

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<UserData> call2 = methods2.userResponse("Bearer " + token, id);

        call2.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call2, Response<UserData> response) {
                if (response.isSuccessful()) {
                    Glide.with(fotoprofile)
                            .load("https://api.calorilin.me/user-detail-images/" + response.body().getImage()).circleCrop().into(fotoprofile);
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<UserData> call2, Throwable t) {

            }
        });

        simpanProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().length() == 0 || username.getText().toString().length() == 0 || username.getText().toString().length() == 0) {
                } else {
                    ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
                    Call<UserEdit> call2 = methods2.usereditResponse("Bearer " + token, id, username.getText().toString(), email.getText().toString(), password.getText().toString());
                    call2.enqueue(new Callback<UserEdit>() {
                        @Override
                        public void onResponse(Call<UserEdit> call2, Response<UserEdit> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            } else if (response.code() == 500) {

                            }
                        }

                        @Override
                        public void onFailure(Call<UserEdit> call2, Throwable t) {

                        }
                    });
                }
                if (!Uri.EMPTY.equals(dataimage)) {
                    final File file = new File(Environment.getExternalStorageDirectory(), "read.me");
                    Uri uri = Uri.fromFile(file);
                    File auxFile = new File(dataimage.getPath());
                    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), auxFile);
                    MultipartBody.Part photoPart = MultipartBody.Part.createFormData("image", auxFile.getName(), requestFile);

                    ApiInterface methods3 = ApiClient.getClient().create(ApiInterface.class);
                    Call<UserDetailPost> call3 = methods3.editGambarResponse("Bearer " + token, id, photoPart);
                    call3.enqueue(new Callback<UserDetailPost>() {
                        @Override
                        public void onResponse(Call<UserDetailPost> call3, Response<UserDetailPost> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            } else if (response.code() == 500) {
                                Toast.makeText(EditProfile.this, "gagal2", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<UserDetailPost> call3, Throwable t) {

                        }
                    });
                }
                if (username.getText().toString().length() == 0 || username.getText().toString().length() == 0 || username.getText().toString().length() == 0) {
                    Toast.makeText(EditProfile.this, "Data Wajib Diisi", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_GALLERY) {
                dataimage = data.getData();
                String[] imageprojection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(dataimage, imageprojection, null, null, null);
                Glide.with(fotoprofile)
                        .load(dataimage)
                        .apply(new RequestOptions().override(500, 500))
                        .circleCrop().into(fotoprofile);

                if (cursor != null)
                {
                    cursor.moveToFirst();
                    int indexImage = cursor.getColumnIndex(imageprojection[0]);
                    part_image = cursor.getString(indexImage);
                    System.out.println(dataimage.getPath());

                    if(part_image != null)
                    {
                        File image = new File(part_image);

                    }
                }
            }
        }
    }
}