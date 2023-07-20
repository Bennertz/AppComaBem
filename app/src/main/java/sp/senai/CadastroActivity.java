package sp.senai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private Button btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        btnListar = findViewById(R.id.btnListar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, ListagemActivity.class);
                startActivity(intent);
            }
        });
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
    }
}