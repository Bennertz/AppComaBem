package sp.senai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    ImageView imageViewFoto;

    private Button btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        imageViewFoto = (ImageView) findViewById(R.id.imageViewFoto);
        findViewById(R.id.btnFotografar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

        btnListar = findViewById(R.id.btnListar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, ListagemActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void inserir(View view) {
        EditText etProdutoNome = findViewById(R.id.editTextProdutoNome);
        String produtoNome = etProdutoNome.getText().toString();
        EditText etProdutoQuantidade = findViewById(R.id.editTextProdutoQuantidade);
        double produtoQuantidade = Double.parseDouble(etProdutoQuantidade.getText().toString());
        EditText etProdutoPreco = findViewById(R.id.editTextProdutoPreco);
        double produtoPreco = Double.parseDouble(etProdutoPreco.getText().toString());

        Produto produto = new Produto(produtoNome, produtoQuantidade, produtoPreco);

        ProdutoDAO dao;
        dao = new ProdutoDAO(this);
        long id = dao.Inserir(produto);
        Toast.makeText(this, "Produto inserido com o ID: "+ id, Toast.LENGTH_SHORT).show();

        etProdutoNome.setText(null);
        etProdutoQuantidade.setText(null);
        etProdutoPreco.setText(null);
        imageViewFoto.setImageBitmap(null);
    }
}