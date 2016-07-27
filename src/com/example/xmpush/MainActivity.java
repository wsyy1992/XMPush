package com.example.xmpush;

import com.example.xmpush.TimeIntervalDialog.TimeIntervalInterface;
import com.xiaomi.mipush.sdk.MiPushClient;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 设置别名
		findViewById(R.id.set_alias).setOnClickListener(new OnClickListener() {
			final EditText editText = new EditText(MainActivity.this);

			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("设置别名")
						.setView(editText)
						.setPositiveButton("确认",
								new AlertDialog.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0,
											int arg1) {

										String alias = editText.getText()
												.toString();

										MiPushClient.setAlias(
												getApplicationContext(), alias,
												null);
									}
								}).setNegativeButton("取消", null).show();

			}
		});

		// 设置账户
		findViewById(R.id.set_account).setOnClickListener(
				new OnClickListener() {
					final EditText editText = new EditText(MainActivity.this);

					@Override
					public void onClick(View arg0) {
						new AlertDialog.Builder(getApplicationContext())
								.setTitle("设置账户")
								.setView(editText)
								.setPositiveButton("确定",
										new AlertDialog.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												String useraccount = editText
														.getText().toString();

												MiPushClient
														.setUserAccount(
																getApplicationContext(),
																useraccount,
																null);

											}
										}).setNegativeButton("取消", null).show();
					}
				});

		// 设置标签
		findViewById(R.id.subscribe_topic).setOnClickListener(
				new OnClickListener() {
					EditText editText = new EditText(MainActivity.this);

					@Override
					public void onClick(View arg0) {
						new AlertDialog.Builder(getApplicationContext())
								.setTitle("确定")
								.setView(editText)
								.setPositiveButton("确定",
										new AlertDialog.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												String subscribe = editText
														.getText().toString();

												MiPushClient
														.subscribe(
																getApplicationContext(),
																subscribe, null);
											}
										}).setNegativeButton("取消", null).show();

					}
				});

		// 撤销别名
		findViewById(R.id.unset_alias).setOnClickListener(
				new OnClickListener() {
					final EditText editText = new EditText(MainActivity.this);

					@Override
					public void onClick(View arg0) {
						new AlertDialog.Builder(MainActivity.this)
								.setTitle(" 撤销别名")
								.setView(editText)
								.setPositiveButton("确认",
										new AlertDialog.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {

												String alias = editText
														.getText().toString();

												MiPushClient
														.unsetAlias(
																getApplicationContext(),
																alias, null);
											}
										}).setNegativeButton("取消", null).show();

					}
				});

		// 撤销账户
		findViewById(R.id.unset_account).setOnClickListener(
				new OnClickListener() {
					final EditText editText = new EditText(MainActivity.this);

					@Override
					public void onClick(View arg0) {
						new AlertDialog.Builder(getApplicationContext())
								.setTitle("撤销账户")
								.setView(editText)
								.setPositiveButton("确定",
										new AlertDialog.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												String useraccount = editText
														.getText().toString();

												MiPushClient
														.unsetUserAccount(
																getApplicationContext(),
																useraccount,
																null);

											}
										}).setNegativeButton("取消", null).show();
					}
				});

		// 撤销标签
		findViewById(R.id.subscribe_topic).setOnClickListener(
				new OnClickListener() {
					EditText editText = new EditText(MainActivity.this);

					@Override
					public void onClick(View arg0) {
						new AlertDialog.Builder(getApplicationContext())
								.setTitle("撤销标签")
								.setView(editText)
								.setPositiveButton("确定",
										new AlertDialog.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												String subscribe = editText
														.getText().toString();

												MiPushClient
														.unsubscribe(
																getApplicationContext(),
																subscribe, null);
											}
										}).setNegativeButton("取消", null).show();

					}
				});
		// 暂停推送
		findViewById(R.id.pause_push).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				MiPushClient.pausePush(getApplicationContext(), null);

			}
		});
		// 恢复推送
		findViewById(R.id.resume_push).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						MiPushClient.resumePush(getApplicationContext(), null);

					}
				});
		// 设置时间
		findViewById(R.id.resume_push).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						new TimeIntervalDialog(getApplicationContext(),
								new TimeIntervalInterface() {

									@Override
									public void cancel() {
										// TODO Auto-generated method stub

									}

									@Override
									public void apply(int startHour,
											int startMin, int endHour,
											int endMin) {
										MiPushClient.setAcceptTime(
												getApplicationContext(),
												startHour, startMin, endHour,
												endMin, null);

									}
								});

					}
				});

	}
}
