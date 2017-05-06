package bebum.com.br.bebum.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import bebum.com.br.bebum.R;

/**
 * Created by addmn.cassio on 05/05/2017.
 */

public class Toolbox {
    public static void exibirMensagem(Context context, String nome) {
        Toast.makeText(
                context,
                nome,
                Toast.LENGTH_LONG
        ).show();
    }

    public static EditText desativarEditText(EditText ed, Boolean ativar, String hint) {

        // ed.setFocusable(ativar);
        ed.setEnabled(ativar);
        //ed.setCursorVisible(ativar);
        if (!ativar) {
            ed.setText("");
        }

        ed.setHint(hint);
        // ed.setKeyListener(null)
        // ed.setBackgroundColor(Color.TRANSPARENT);

        return ed;
    }

    public static Spinner desativarSpinner(Spinner sp, Boolean ativar) {

        // ed.setFocusable(ativar);
        sp.setEnabled(ativar);

        //ed.setCursorVisible(ativar);
        //sp.setHint(hint);
        // ed.setKeyListener(null);
        // ed.setBackgroundColor(Color.TRANSPARENT);

        return sp;
    }

    public static String webServices(String usuario, String senha, String tipo, Boolean local) {
        String URL_JSON = ""; // ";
        if (local) {
            URL_JSON = "http://xxxxxx";
        }



        return URL_JSON;
    }

    public static String webServicesEnergy(String IDWEB, String tipo, String chave, Boolean local, String senha) {
        String URL_JSON ="";
        if (local) {
            URL_JSON = "";
        }


        if (tipo == "login") {
            URL_JSON += "&ids=" + chave;
            URL_JSON += "&senha=" + senha;
        } else {
            URL_JSON += "&ids=0";
            URL_JSON += "&senha=0";
        }

        URL_JSON += "&tipo=" + tipo;

        return URL_JSON;
    }

    // Exibe a notificaÁ„o
    public static void Notificacao(String mensagem, NotificationManager nm, Notification notification) {

        final String mensagemBarraStatus = "Notificação. Dev Mobile Brasil";
        final String titulo = "Dev Mobile Brasil Notificação";

        //Classe que voce Gostaria de Chamar Assim que clickado na notificacao.
        //Voce Pode colocar outra acitivity para outra tela aqui se desejar.


        // Servico de Notificacao


        //Escolhendo o Icone da Notificacao, Mensagem da Barra de Status e o Tempo que sera executado o horario.
        Notification notificacao = notification;

        // PendingIntent para executar a Activity se o usuario selecionar a notificaÁ„o1

        // Intent intentMensagem = new Intent(this, activity);
        //  PendingIntent p = PendingIntent.getActivity(this, 0, intentMensagem, 0);

        // Reunindo todas as informacoes e Montando a mensagem e a notificacao
        // notificacao.setLatestEventInfo(this, titulo, mensagem, p);

        // espera 100ms e vibra por 250ms.
        notificacao.vibrate = new long[]{100, 250, 100, 500};
        notificacao.defaults |= Notification.DEFAULT_LIGHTS;
        notificacao.defaults |= Notification.DEFAULT_SOUND;
        notificacao.flags |= Notification.FLAG_AUTO_CANCEL;

        // id (n˙mero ˙nico) que identifica esta notificaÁ„o. Mesmo id utilizado para cancelar
        nm.notify(R.string.app_name, notificacao);
    }

    public static void ProgressDialogCustom(Context context, String Titulo, int icon, ArrayList lista) {
        final ProgressDialog progressDialog;

        int nMaximo;
        progressDialog = new ProgressDialog(context);
        progressDialog.setIcon(icon);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);

        if (lista.size() < 100) {
            nMaximo = 100;
        } else {
            nMaximo = lista.size();
        }

        final int nMax = nMaximo;
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle(Titulo);
        progressDialog.show();


        new Thread() {

            public void run() {

                try {

                    for (int i = 0; i <= nMax; i++) {
                        //   Thread.sleep(100);
                        progressDialog.incrementProgressBy(1);

                    }

                    progressDialog.dismiss();
                } catch (Exception e) {

                }
            }
        }.start();

    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void Notificacoes(String titulo, String mensagem, Context ctx, PendingIntent pi, String _NOTIFICATION_SERVICE, int idNotificacao, int logo) {

        NotificationManager nm = (NotificationManager)
                ctx.getSystemService(_NOTIFICATION_SERVICE);


        Notification.Builder nf = new Notification.Builder(ctx);
        nf.setSmallIcon(logo);
        nf.setContentIntent(pi);
        nf.setContentTitle(titulo);
        nf.setContentText(mensagem);
        nf.setAutoCancel(true);
        nf.setDefaults(
                Notification.DEFAULT_SOUND |
                        Notification.DEFAULT_VIBRATE
        );

        // A versao do sistema operacional no SmartPhone
        int versao = Build.VERSION.SDK_INT;

        if (versao >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            // TATATATA TA
            nm.notify(idNotificacao, nf.build());
        } else {
            // TATATATA TA
            nm.notify(idNotificacao, nf.getNotification());
        }
    }





    public static Boolean VldEditCustom(EditText campo,Boolean focus) {

        String conteudo = campo.getText().toString().trim();
        boolean cancel = true;
        View focusView = null;

        if (TextUtils.isEmpty(conteudo)) {
            campo.setError("Preenchimento Obrigatorio");
            focusView = campo;
            cancel = false;
        }
        if (!cancel && focus) {
            focusView.requestFocus();
        }


        return cancel;
    }
    public static Boolean VldAutoCompleteTextViewCustom(AutoCompleteTextView campo, Boolean focus) {
        String conteudo = campo.getText().toString().trim();
        boolean cancel = true;
        View focusView = null;

        if (TextUtils.isEmpty(conteudo)) {
            campo.setError("Preenchimento Obrigatorio");
            focusView = campo;
            cancel = false;
        }
        if (!cancel && focus) {
            focusView.requestFocus();
        }


        return cancel;
    }
    public static boolean VldSpinnerCustom(Spinner campo, int id,Boolean focus) {
        //String selecao = campo.getItemAtPosition(id).toString();

        boolean cancel = true;
        View focusView = null;

        if (id == 0) {
            SpinnerAdapter adapter = campo.getAdapter();
            ((TextView) campo.getSelectedView()).setError("Preenchimento Obrigatorio");
            focusView = campo;
            cancel = false;
        }
        if (!cancel && focus) {
            focusView.requestFocus();
        }


        return cancel;
    }




    public static String StrZeroEsquerda(String value, int n) {
        String s = value.trim();
        StringBuffer resp = new StringBuffer();
        int fim = n - s.length();
        for (int x = 0; x < fim; x++)
            resp.append('0');
        return  resp+s ;
    }
}

