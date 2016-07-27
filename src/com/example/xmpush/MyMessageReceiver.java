package com.example.xmpush;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

public class MyMessageReceiver extends PushMessageReceiver {
	private String mRegId;// ��ǰ�豸�ϵ�ǰapp��Ψһ��ʾ(ע��id)
	private long mResultCode = -1;
	private String mReason;
	private String mCommand;
	private String mMessage;// ��������
	private String mTopic;// ��������
	private String mAlias;// ����
	private String mUserAccount;// �ʺ�
	private String mStartTime;// ��ʼʱ��
	private String mEndTime;// ����ʱ��

	/**
	 * ���ڽ��ܷ��������͵�͸����Ϣ
	 */
	@Override
	public void onReceivePassThroughMessage(Context context,
			MiPushMessage message) {
		// TODO Auto-generated method stub
		super.onReceivePassThroughMessage(context, message);
		mMessage = message.getContent();
		System.out.println("mMessage" + mMessage);
		String string = message.toString();
		System.out.println("onReceivePassThroughMessage" + string);
		if (!TextUtils.isEmpty(message.getTopic())) {
			mTopic = message.getTopic();
			System.out.println("mTopic" + mTopic);
		} else if (!TextUtils.isEmpty(message.getAlias())) {
			mAlias = message.getAlias();
			System.out.println("mAlias" + mAlias);

		} else if (!TextUtils.isEmpty(message.getUserAccount())) {
			mUserAccount = message.getUserAccount();
			System.out.println("mUserAccount" + mUserAccount);
		}
	}

	/**
	 * �������շ�����������֪ͨ����Ϣ���û����֪ͨ��ʱ������
	 */
	@Override
	public void onNotificationMessageClicked(Context context,
			MiPushMessage message) {
		// TODO Auto-generated method stub
		super.onNotificationMessageClicked(context, message);
		mMessage = message.getContent();
		System.out.println("click");
		if (!TextUtils.isEmpty(message.getTopic())) {
			mTopic = message.getTopic();
		} else if (!TextUtils.isEmpty(message.getAlias())) {
			mAlias = message.getAlias();

		} else if (!TextUtils.isEmpty(message.getUserAccount())) {
			mUserAccount = message.getUserAccount();
		}
		String string = message.toString();
		System.out.println("onNotificationMessageClicked" + string+"/nmMessage"+mMessage);
		
	}

	/**
	 * �������շ�����������֪ͨ����Ϣ����Ϣ����ͻ���ʱ���������ҿ��Խ���Ӧ����ǰ̨ʱ������֪ͨ��֪ͨ��Ϣ��
	 */
	@Override
	public void onNotificationMessageArrived(Context context,
			MiPushMessage message) {
		// TODO Auto-generated method stub
		super.onNotificationMessageArrived(context, message);
		mMessage = message.getContent();
		if (!TextUtils.isEmpty(message.getTopic())) {
			mTopic = message.getTopic();
		} else if (!TextUtils.isEmpty(message.getAlias())) {
			mAlias = message.getAlias();

		} else if (!TextUtils.isEmpty(message.getUserAccount())) {
			mUserAccount = message.getUserAccount();
		}
		String string = message.toString();
		System.out.println("onNotificationMessageArrived" + string);
	}

	/**
	 * �������տͻ��������������������Ϣ�󷵻ص���Ӧ
	 */
	@Override
	public void onCommandResult(Context context, MiPushCommandMessage message) {
		// TODO Auto-generated method stub
		super.onCommandResult(context, message);
		String command = message.getCommand();
		List<String> arguments = message.getCommandArguments();
		String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments
				.get(0) : null);
		String cmdArg2 = ((arguments != null && arguments.size() > 1) ? arguments
				.get(1) : null);
		if (MiPushClient.COMMAND_REGISTER.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mRegId = cmdArg1;
			}
		} else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mAlias = cmdArg1;
			}
		} else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mAlias = cmdArg1;
			}
		} else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mTopic = cmdArg1;
			}
		} else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mTopic = cmdArg1;
			}
		} else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mStartTime = cmdArg1;
				mEndTime = cmdArg2;
			}
		}
		String string = message.toString();
		System.out.println("onCommandResult" + string);
	}

	/**
	 * �������ܿͻ��������������ע��������Ϣ�󷵻ص���Ӧ��
	 */
	@Override
	public void onReceiveRegisterResult(Context context,
			MiPushCommandMessage message) {
		// TODO Auto-generated method stub
		super.onReceiveRegisterResult(context, message);
		String command = message.getCommand();
		List<String> arguments = message.getCommandArguments();
		String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments
				.get(0) : null);
		String cmdArg2 = ((arguments != null && arguments.size() > 1) ? arguments
				.get(1) : null);
		if (MiPushClient.COMMAND_REGISTER.equals(command)) {
			if (message.getResultCode() == ErrorCode.SUCCESS) {
				mRegId = cmdArg1;
			}
		}
		String string = message.toString();
		System.out.println("onReceiveRegisterResult" + string);

	}

}
