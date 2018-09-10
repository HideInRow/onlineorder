package util;
/**
 * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
 * @author huwei
 *
 */
public class SplitUtil {
	public static String getFileName(String filename) {
		String[] tempArr1 = filename.split(";");
		String[] tempArr2 = tempArr1[2].split("=");
		String name = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
		return name;
	}
}
