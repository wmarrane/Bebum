package bebum.com.br.bebum.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import bebum.com.br.bebum.banco.Constantes;


/**
 * Created by addmn.cassio on 25/03/2017.
 */

public class ServiceDownload extends IntentService {

    public ServiceDownload() {
        super("ServicoDownload");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
       // ClientesDao clientesDao = new ClientesDao(ServiceDownload.this);
     //   List<Clientes> clientes = null;
      //  int valor = ProtheusHttp.carregarJsonTotalCliente(true, "", "");
      //  int divisor = 200;
      //  int totalcadastrado = clientesDao.obterTotalCliente();
      //  int modulo = (valor-totalcadastrado) % divisor;
      //  long grupo = (valor-totalcadastrado) / divisor;
      //  if( modulo<divisor){
      //      grupo++;
      //  }
      //  String codigo="";
        try {
            int indice = 0;
            while (indice < 2) {
                Thread.sleep(1000);
               //  codigo = clientesDao.obterUltimoCodigo();
              //  clientes = ProtheusHttp.carregarJsonCliente(true, "", codigo);
               // int max = clientes.size();
               // for (int i = 0; i < max; i++) {
                //   clientesDao.inserirCliente(clientes.get(i));
               //   }

                indice++;
                enviarMensagem("Atualizando clientes aguarde 1 de "+String.valueOf(indice));
                Log.d("SERVICO CONTADOR", String.valueOf(indice));


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            enviarMensagem("finalizado");
        }
    }

    public void enviarMensagem(String status) {
        Intent sendIntent = new Intent();
        sendIntent.putExtra(Constantes.EVENTO_RETORNO, status);
        sendIntent.putExtra(Constantes.QUANTIDADE, status);
        sendIntent.setAction(Constantes.EVENTO);
        sendIntent.addCategory(Intent.CATEGORY_DEFAULT);

        sendBroadcast(sendIntent);
    }
}
