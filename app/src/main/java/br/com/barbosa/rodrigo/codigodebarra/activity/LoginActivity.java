package br.com.barbosa.rodrigo.codigodebarra.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import br.com.barbosa.rodrigo.codigodebarra.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.email)
    protected EditText email;

    @BindView(R.id.password)
    protected EditText password;

    @BindView(R.id.btOk)
    protected Button btOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.btOk)
    protected void onClickOk(){
        Intent i = new Intent(this, ListScannersActivity.class);
        startActivity(i);
    }


}

