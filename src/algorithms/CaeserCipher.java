package algorithms;

public class CaeserCipher {
	public char[] encoder = new char[26];
	public char[] decoder = new char[26];

	public CaeserCipher(int k) {
		for (int n = 0; n <= 25; n++) {
			encoder[n] = (char) ('A' + (n + k) % 26);
			decoder[n] = (char) ('A' + (n - k + 26) % 26);
		}
	}

	public String encrypt(String msg) {
		return transform(msg, encoder);
	}

	public String decrypt(String secret) {
		return transform(secret, decoder);
	}

	public String transform(String msg, char[] coder) {
		char[] convert = msg.toCharArray();

		for (int i = 0; i < convert.length; i++) {
			if (Character.isAlphabetic(convert[i]))
				if (Character.isUpperCase(convert[i]))
					convert[i] = coder[convert[i] - 'A'];
				else {
					convert[i] = Character.toUpperCase(convert[i]);
					convert[i] = Character.toLowerCase(coder[convert[i] - 'A']);
				}

		}

		return new String(convert);
	}

	public static void main(String[] args) {
		CaeserCipher cip = new CaeserCipher(4);
		String secret = cip.encrypt("My NAME IS SHADY");
		System.out.println("Encryptor : " + new String(cip.encoder));
		System.out.println("Decryptor : " + new String(cip.decoder));
		System.out.println("Secret : " + secret);
		System.out.println("Decoded Message : " + cip.decrypt(secret));
	}
}
