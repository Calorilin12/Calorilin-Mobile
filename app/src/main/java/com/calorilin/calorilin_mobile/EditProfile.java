package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.user.UserData;
import com.calorilin.calorilin_mobile.model.userpost.UserEdit;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {
    EditText username,email;
    TextInputEditText password;
    Button simpanProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");

        username = findViewById(R.id.editTextUsername);
        email = findViewById(R.id.editTextEmail);
        password = (TextInputEditText)findViewById(R.id.editTextPassword2);
        simpanProfile = findViewById(R.id.button_edit_profile);

        simpanProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().length()==0 ||username.getText().toString().length()==0 ||username.getText().toString().length()==0){

                }
                else {
                    ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
                    Call<UserEdit> call2 = methods2.usereditResponse("Bearer " + token, id,username.getText().toString(), email.getText().toString(),password.getText().toString());
                    call2.enqueue(new Callback<UserEdit>() {
                        @Override
                        public void onResponse(Call<UserEdit> call2, Response<UserEdit> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                finish();

                            } else if (response.code() == 500) {

                            }
                        }

                        @Override
                        public void onFailure(Call<UserEdit> call2, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}