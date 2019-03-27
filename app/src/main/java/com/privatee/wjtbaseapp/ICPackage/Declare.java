package com.privatee.wjtbaseapp.ICPackage;


//import com.sun.jna.Native;

import com.sun.jna.Library;

public class Declare
{
	public interface mwrf extends Library {
		public int rf_init(short port, long buad);
		public short rf_exit(int icdev);
		public short rf_get_status(int icdev, byte[] ver);
		public short rf_beep(int icdev, short time);
		public short rf_load_key(int icdev, short mode, short sector, byte[] key);
		public short rf_load_key_hex(int icdev, short mode, short sector, String key);
		public short rf_card(int icdev, short mode, byte[] Snr);
		public short rf_authentication(int icdev, short mode, short sector);
		public short rf_read(int icdev, short addr, byte[] data);
		public short rf_read_hex(int icdev, short addr, byte[] data);
		public short rf_write(int icdev, short addr, byte[] data);
		public short rf_write_hex(int icdev, short addr, byte[] data);
		public short rf_changeb3(int icdev, short SecNr, byte[] KeyA, short _B0, short _B1, short _B2, short _B3, short _Bk, byte[] _KeyB);
		
		public short rf_pro_rst(int icdev, byte[] _Data);
		public short  rf_pro_trn(int icdev, byte[] problock, byte[] recv);

		public short hex_a(byte[] hex, byte[] a, short len);
		public short a_hex(byte[] a, byte[] hex, short len);
	}
}
