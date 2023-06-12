
package sp.senai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements Runnable {

    Thread thread;
    Handler handler;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        i = 1;
        try {
            /**
             * Loop para fazer activity_main ficar aberta por alguns instantes, antes de abrir a
             * activity_cadastro **/
            while (i < 100) {
                Thread.sleep(30);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                    }
                });
            }
        } catch (Exception e) {}
        finish();
        // Inicia a activity_cadastro
        startActivity(new Intent(this, CadastroActivity.class));
    }
}