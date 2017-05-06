package bebum.com.br.bebum.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by addmn.cassio on 10/03/2017.
 */

public class MessageVerifyServiceReceiver extends BroadcastReceiver {

    private final String BOOT_COMPLETED_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context arg0, Intent arg1) {

        if(arg1.getAction().equals(BOOT_COMPLETED_ACTION))
        {
            Intent myIntent = new Intent(arg0, MessageVerifyService.class);
            arg0.startService(myIntent);
            Toast.makeText(arg0, "Serviço verificador de mensagens iniciado novamente!",Toast.LENGTH_LONG).show();
        }else{
            int i = 1;
        }

    }

}