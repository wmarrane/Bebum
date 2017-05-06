package bebum.com.br.bebum.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import bebum.com.br.bebum.R;
import bebum.com.br.bebum.ui.MainActivity;
import bebum.com.br.bebum.util.Toolbox;


/**
 * Created by addmn.cassio on 10/03/2017.
 */

public class MessageVerifyService extends Service {
    private Handler serviceHandler;
    private Task myTask;
    NotificationManager notify;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        notify = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        myTask = new Task();
        serviceHandler = new Handler();
        serviceHandler.postDelayed(myTask, 1000);

        return START_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        try {
            serviceHandler.removeCallbacks(myTask);
            serviceHandler = null;

        } catch (Exception e) {

        }
    }

    public void showNotificationAlert(int numMensagens) {
        Context ctx = getBaseContext();
        Intent intent = new Intent(ctx, MainActivity.class); // coloque sua activity para ver as mensagens não lidas

        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Notification note = new Notification(R.drawable.bear, "Mensagens não Lidas", System.currentTimeMillis());
        PendingIntent i = PendingIntent.getActivity(ctx, 0, intent, 0);

       /* note.setLatestEventInfo(getBaseContext(),
                "Mensagens não lidas",
                "Existem " + numMensagens + " mensagens não lidas",
                null);*/
        //Notificacoes


        Toolbox.Notificacoes(
                "Saldo Produtos",
                "Saldos baixados",
                ctx,
                i,
                NOTIFICATION_SERVICE,
                100,
                R.drawable.bear);

       // Hide the notification after its selected
        note.flags |= Notification.FLAG_AUTO_CANCEL;
        note.defaults |= Notification.DEFAULT_SOUND;
        notify.cancel(0x1);//retira se houver
        notify.notify(0x1, note);
    }


    class Task implements Runnable {
        @Override
        public void run() {
            //VERIFICAR AQUI SE HÁ UMA NOVA MENSAGEM


            int numMens = 44; //verificarMensagensNaoLidas();
            if (numMens > 0)
                showNotificationAlert(numMens);


            //executa de uma em uma hora
        //    serviceHandler.postDelayed(this, 3600000);// 1 hora
            serviceHandler.postDelayed(this,30000 );//30 segundos
        }


    }
}