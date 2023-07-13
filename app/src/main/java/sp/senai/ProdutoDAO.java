package sp.senai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> obterTodos() {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produto", new String[]{"produtoId", "produtoNome", "produtoQuantidade", "produtoPreco"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Produto p = new Produto();
            p.setProdutoId(cursor.getInt(0));
            p.setProdutoNome(cursor.getString(1));
            p.setProdutoQuantidade(cursor.getDouble(2));
            p.setProdutoPreco(cursor.getDouble(3));
            produtos.add(p);
        }
        return produtos;
    }
}
