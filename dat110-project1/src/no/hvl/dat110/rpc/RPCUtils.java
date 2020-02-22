package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.MessageConfig;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {
		
		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0]=rpcid;
	
		
		for(int i =0; i < str.length(); i++) {
			encoded[i+1]=(byte) str.charAt(i);
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

	
		String decoded ="";
		byte[] temp= new byte[MessageConfig.SEGMENTSIZE];
		int size=data[0];
		for(int i =0; i < data.length-1; i++) {
			temp[i]=data[i+1];
		}
		
		decoded= new String(temp).trim();

		// TODO: unmarshall String contained in data into decoded

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[128];

		// TODO: marshall RPC identifier in case of void type
		encoded[0]=rpcid;
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		byte[] encoded = new byte[128];
		

		// TODO: marshall RPC identifier in case of void type
		
		return;
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded= new byte[5];

		// TODO: marshall RPC identifier and string into byte array
		
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(x);
		
		encoded[0] = rpcid;
		
		for (int i = 1; i < encoded.length; i++) {
			encoded[i] = b.get(i-1);
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded=0;

		// TODO: unmarshall integer contained in data


		ByteBuffer buffer = ByteBuffer.allocate(4);
		for (int i = 1; i < data.length; i++) {
				buffer.put(i-1, data[i]);
		}
		decoded=buffer.getInt();
		
		return decoded;

	}
}
