package sp.senai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String bdComaBem = "ComaBem.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, bdComaBem, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bdComaBem) {
        bdComaBem.execSQL("CREATE TABLE produto (produtoId integer primary key autoincrement, produtoNome varchar(200), produtoQuantidade decimal(5,2), produtoPreco decimal(5,2))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bdComaBem, int oldVersion, int newVersion) {

    }
}
