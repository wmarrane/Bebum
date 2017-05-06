package bebum.com.br.bebum.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nalmir on 18/03/2017.
 */
public class Dao {

    private Context context;
    protected SQLiteDatabase db;

    public Dao(Context context) {
        this.context = context;
    }

    //
    public void abrirBanco() {
        DataBaseHelper baseHelper = new DataBaseHelper(
                context,
                Constantes.BANCODEDADOS,
                null,
                Constantes.VERSAO_BANCO
        );

        this.db = baseHelper.getWritableDatabase();

    }

    // Ensinei ele a fechar o banco de dados
    public void fecharBanco() {
        if (db != null) {
            db.close();
        }
    }
}
