package movil.tesis.miguel.opuestos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.migue.opuestos.nivel1;

public class Principal extends AppCompatActivity {

    public Button n1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_principal);


    }

    public void init(View view) {
        n1=(Button)findViewById(R.id.nivel1);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiarnivel1 = new Intent(Principal.this,nivel1.class);
                startActivity(cambiarnivel1);
            }
        });
    }
}
