package bebum.com.br.bebum.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by nalmir on 18/03/2017.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            StringBuilder sb = new StringBuilder();
            // Tabela Contato
        /*    sb.append("CREATE TABLE IF NOT EXISTS [" + UsuarioDao.TABELA + "] ( " +
                    "  [" + UsuarioDao.IDCONTATO + "] TEXT ,  " +
                    "  [" + UsuarioDao.NOME + "] TEXT , " +
                    "  [" + UsuarioDao.EMAIL + "] TEXT ,  " +
                    "  [" + UsuarioDao.SENHA + "] TEXT , " +
                    "  [" + UsuarioDao.CARGO + "] TEXT , " +
                    "  [" + UsuarioDao.MATRICULA + "] TEXT , " +
                    "  [" + UsuarioDao.EMPRESA + "] TEXT , " +
                    "  [" + UsuarioDao.FILIAL + "] TEXT  " +
                    "    );");
*/

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {

            StringBuilder sb = new StringBuilder();
            //
            // Tabela Contato
           /* sb.append("DROP TABLE IF EXISTS [" + ClientesDao.TABELA + "] ;");
            sb.append("DROP TABLE IF EXISTS [" + FornecedoresDao.TABELA + "] ;");
            sb.append("DROP TABLE IF EXISTS [" + SZXDao.TABELA + "] ;");
            sb.append("DROP TABLE IF EXISTS [" + SZZDao.TABELA + "] ;");*/
            // Tabel Ramo Atividade
            //sb.append("");

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }


        } catch (Exception e) {
        }

        onCreate(db);
    }
}
