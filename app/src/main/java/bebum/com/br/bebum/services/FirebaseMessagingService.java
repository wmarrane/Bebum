package bebum.com.br.bebum.services;


import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

import bebum.com.br.bebum.R;
import bebum.com.br.bebum.banco.Constantes;
import bebum.com.br.bebum.ui.MainActivity;
import bebum.com.br.bebum.util.Toolbox;


/**
 * Created by filipp on 5/23/2016.
 */
public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getData().get("message"),
                remoteMessage.getData().get("dados"),
                remoteMessage.getData().get("tipomessage"));
    }

    private void showNotification(String message, String dados,String tipomessage) {

        Intent i = new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Orcamentos")
                .setContentText(message + " - "+ dados)
              //  .setSmallIcon(R.drawable.ic_cliente_v9)
                .setContentIntent(pendingIntent);
      Toolbox.Notificacoes(
                "Saldo Produtos",
                message+ " - "+ dados,
                this,
                pendingIntent,
                NOTIFICATION_SERVICE,
                0,
                R.drawable.bear);

        //ToolBox.exibirMensagem(this,message+ " - "+ dados       );
       /* NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());*/
        enviarMensagem(dados,tipomessage);
    }
    public void enviarMensagem(String status, String tipo) {
        Intent sendIntent = new Intent();
        sendIntent.putExtra(Constantes.EVENTO_RETORNO, status);
        sendIntent.putExtra(Constantes.QUANTIDADE, tipo);
        sendIntent.setAction(Constantes.EVENTO);
        sendIntent.addCategory(Intent.CATEGORY_DEFAULT);

        sendBroadcast(sendIntent);
    }

}
