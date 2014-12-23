package ru.startandroid.develop.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;

	  EditText etNum1;
	  EditText etNum2;

	  Button btnAdd;
	  Button btnSub;
	  Button btnMult;
	  Button btnDiv;

	  TextView tvResult;

	  String oper = "";

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    // ������� ��������
	    etNum1 = (EditText) findViewById(R.id.Num1);
	    etNum2 = (EditText) findViewById(R.id.Num2);

	    btnAdd = (Button) findViewById(R.id.btnAdd);
	    btnSub = (Button) findViewById(R.id.btnSub);
	    btnMult = (Button) findViewById(R.id.btnMult);
	    btnDiv = (Button) findViewById(R.id.btnDiv);

	    tvResult = (TextView) findViewById(R.id.tvResult);

	    // ����������� ����������
	    btnAdd.setOnClickListener(this);
	    btnSub.setOnClickListener(this);
	    btnMult.setOnClickListener(this);
	    btnDiv.setOnClickListener(this);

	  }

	  public void onClick(View v) {
	    float num1 = 0;
	    float num2 = 0;
	    float result = 0;

	    // ��������� ���� �� �������
	    if (TextUtils.isEmpty(etNum1.getText().toString())
	        || TextUtils.isEmpty(etNum2.getText().toString())) {
	      return;
	    }

	    // ������ EditText � ��������� ���������� �������
	    num1 = Float.parseFloat(etNum1.getText().toString());
	    num2 = Float.parseFloat(etNum2.getText().toString());

	    // ���������� ������� ������ � ��������� ��������������� ��������
	    // � oper ����� ��������, ����� ����� ������������ � ������
	    switch (v.getId()) {
	    case R.id.btnAdd:
	      oper = "+";
	      result = num1 + num2;
	      break;
	    case R.id.btnSub:
	      oper = "-";
	      result = num1 - num2;
	      break;
	    case R.id.btnMult:
	      oper = "*";
	      result = num1 * num2;
	      break;
	    case R.id.btnDiv:
	      oper = "/";
	      result = num1 / num2;
	      break;
	    default:
	      break;
	    }

	    // ��������� ������ ������
	    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
	}
	// �������� ����
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	  // TODO Auto-generated method stub
	  menu.add(0, MENU_RESET_ID, 0, "Reset");
	  menu.add(0, MENU_QUIT_ID, 0, "Quit");
	  return super.onCreateOptionsMenu(menu);
	  }

	  // ��������� ������� �� ������ ����
	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	  // TODO Auto-generated method stub
	  switch (item.getItemId()) {
	  case MENU_RESET_ID:
	  // ������� ����
	  etNum1.setText("");
	  etNum2.setText("");
	  tvResult.setText("");
	  break;
	  case MENU_QUIT_ID:
	  // ����� �� ����������
	  finish();
	  break;
	  }
	  return super.onOptionsItemSelected(item);
	  }
	}