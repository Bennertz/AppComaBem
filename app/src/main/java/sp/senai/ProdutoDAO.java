package sp.senai;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ProdutoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO (Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long Inserir (Produto produto) {
        ContentValues values = new ContentValues();
        values.put("produtoNome", produto.getProdutoNome());
        values.put("produtoQuantidade", produto.getProdutoQuantidade());
        values.put("produtoPreco", produto.getProdutoPreco());
        return banco.insert("produto", null, values);
    }
}
