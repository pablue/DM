package diary.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;

public class Htmlcompressor {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Htmlcompressor main = new Htmlcompressor();
		main.cssCompress("c:/2.html");
	}

	public static void cssCompress(String filename) throws Exception {
		StringBuffer cssBuf = new StringBuffer();
		readFileToBuffer(filename, cssBuf);
		HtmlCompressor compressor = new HtmlCompressor();
		compressor.setCompressCss(true);

		String compressedCss = compressor.compress(cssBuf.toString());
		WriteStringToFile(filename, compressedCss);
	}

	private static void readFileToBuffer(String fileName, StringBuffer sb) {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(new File(fileName)), ConstantUtils.DefaultEncoding);
			BufferedReader br = new BufferedReader(in);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 输出成文件
	 * 
	 * @param OutFileName
	 *            要对压缩的给一个输出文件名
	 * @param content
	 * @throws IOException
	 */
	private static void WriteStringToFile(String OutFileName, String content) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File(OutFileName)), ConstantUtils.DefaultEncoding);
		BufferedWriter buffer = new BufferedWriter(out);
		buffer.write(content);
		buffer.flush();
		out.flush();
		buffer.close();
		out.close();
	}
}
