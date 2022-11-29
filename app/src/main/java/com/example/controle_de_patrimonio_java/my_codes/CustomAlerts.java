package com.example.controle_de_patrimonio_java.my_codes;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author Matheus Martinelli
 * Created on 06/11/2022
 * martinelli.matheus2@gmail.com
 */

/**
 * Classe responsavel por tornar mais rapido a construção de Dialogs
 */
public class CustomAlerts {
    private static final String BT_CONFIRMAR = "Confirmar ";
    private static final String BT_SIM = "Sucesso na execução. ";
    /**-------------------------------------ALERT DIALOG'S------------------------
     *para passar um Icone como parametro basta ultilizar android.R.drawable.
     *Para configurar um evento de clique basta criar um objeto  AlertDialog.Builder alerta = XString.dialogSim(..)
     * NÃO ULTILIZAR O SET SET POSIVITE OU NEGATIVE BUTTON POIS JA FOI CHAMADO O METODO .SHOW()*/
    public static AlertDialog.Builder dialogSim(Context context, String mensagem){


        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle("Alerta");
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( android.R.drawable.ic_dialog_alert );

        //Configura acoes para sim e nao
        dialog.setPositiveButton(BT_SIM, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {            }        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
        return dialog;

    }
    public static AlertDialog.Builder dialogSim(Context context,String titulo,String mensagem){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle(titulo);
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( android.R.drawable.ic_dialog_alert );

        //Configura acoes para sim e nao
        dialog.setPositiveButton(BT_SIM, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {            }        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
        return dialog;

    }
    public static AlertDialog.Builder dialogSim(Context context,String titulo,String mensagem, int iconID){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle(titulo);
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( iconID );

        //Configura acoes para sim e nao
        dialog.setPositiveButton(BT_SIM, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {            }        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
        return dialog;

    }
    /**
    *Aqui deve-se configurar o setpositive ou negative e usar o .create.show();  */
    public static AlertDialog.Builder dialog(Context context, String mensagem){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle("Alerta");
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( android.R.drawable.ic_dialog_alert );


        //Criar e exibir AlertDialog
        dialog.create();
        return dialog;

    }
    public static AlertDialog.Builder dialog(Context context,String titulo,String mensagem){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle(titulo);
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( android.R.drawable.ic_dialog_alert );


        //Criar e exibir AlertDialog
        dialog.create();
        return dialog;

    }
    public static AlertDialog.Builder dialog(Context context,String titulo,String mensagem, int iconID){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( context );

        //Configurar titulo e mensagem
        dialog.setTitle(titulo);
        dialog.setMessage(mensagem);

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( iconID );


        return dialog;

    }
    public static AlertDialog.Builder imputDecimalDialog(Context context, String titulo,String mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Title");

// Set up the input
        final EditText input = new EditText(context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL );
        builder.setView(input);

// Set up the buttons
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                m_Text = input.getText().toString();
//            }
//        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

      //  builder.show();
        return builder;
    }

    /*-------------------------------------SNACKBAR------------------------*/
    /*PARA PASSAR A ACTIVITY ULTILIZE this ou MainActivity.this*/
    public static void snackbarConfirmar(Activity activity, String mensagem){
        View view = activity.findViewById(android.R.id.content);
        Snackbar.make(
                        view,
                        mensagem,
                        Snackbar.LENGTH_LONG
                ).setAction(BT_CONFIRMAR, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor( activity.getResources().getColor( android.R.color.holo_orange_dark ) )
                .show();
    }

    /**
     *
     * @param activity use NomeActivity.this ou simplismente this
     * @param mensagem mensagem que deseja exibir
     * @param color cor de fundo da snackbar
     * @return snackbnar configurada use .show ou use setAction para criar eventos
     */
    public static Snackbar snackbar(Activity activity, String mensagem, int color){
        View view = activity.findViewById(android.R.id.content);
        return  Snackbar.make(
                view,
                mensagem,
                Snackbar.LENGTH_LONG
        ).setBackgroundTint(color);
    }



    /*-------------------------------------TOAST------------------------*/
    /*PARA PASSAR A ACTIVITY ULTILIZE this ou MainActivity.this*/
    public static void toastCentralizado(Activity activity, String mensagem){
        Toast toast = Toast.makeText(activity, mensagem, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

}
