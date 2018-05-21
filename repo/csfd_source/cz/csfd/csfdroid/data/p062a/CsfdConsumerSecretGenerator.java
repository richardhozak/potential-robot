package cz.csfd.csfdroid.data.p062a;

import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import org.apache.http.HttpStatus;

/* compiled from: CsfdConsumerSecretGenerator */
public class C2014b {
    private final int[][] scrambledConsumerKey = new int[][]{new int[]{69, ScriptIntrinsicBLAS.RIGHT, 284, 432, 53, 168, 288, 528, 102, 114, 344, 696, 116, 234, HttpStatus.SC_NO_CONTENT, 952}, new int[]{110, 78, 172, 472, 776, 97, 238, HttpStatus.SC_FAILED_DEPENDENCY, 792, 86, 208, 280, 560, 104, 96, 308}, new int[]{284, 100, 49, 208, 448, 552, 106, HttpStatus.SC_ACCEPTED, 220, 928, 118, 150, HttpStatus.SC_METHOD_FAILURE, 920, 70, 208}, new int[]{680, 340, 96, 49, 228, 396, 704, 120, 104, HttpStatus.SC_MULTIPLE_CHOICES, 624, 120, 210, 212, 784, 51}, new int[]{56, 912, 212, 108, 116, 220, 332, 864, 107, 102, 472, 456, 100, ScriptIntrinsicBLAS.UNIT, 448, 384}, new int[]{240, 117, 536, 320, 110, 119, 134, HttpStatus.SC_BAD_REQUEST, 384, 99, 110, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, 568, 110, 152, 460}, new int[]{432, HttpStatus.SC_ACCEPTED, 106, 704, 340, 172, 117, 102, 228, 840, 71, HttpStatus.SC_PARTIAL_CONTENT, 332, 824, 50, 170}, new int[]{920, HttpStatus.SC_NO_CONTENT, 216, 56, 832, 316, 144, 118, 158, 468, 816, 48, 194, 216, 864, 88}, new int[]{88, 944, HttpStatus.SC_NO_CONTENT, 208, 106, 888, 348, 228, 112, 156, 308, HttpStatus.SC_FAILED_DEPENDENCY, 118, 110, 352, HttpStatus.SC_REQUEST_TIMEOUT}, new int[]{228, 112, 936, HttpStatus.SC_OK, 210, 116, 432, 260, 150, 116, 174, 224, 912, 81, 162, 264}, new int[]{284, 176, 76, 680, 448, 172, 48, 936, 396, 96, 100, 108, 224, 432, 118, 112}, new int[]{960, 196, 156, 105, HttpStatus.SC_BAD_REQUEST, HttpStatus.SC_MULTIPLE_CHOICES, 172, 49, 864, 476, HttpStatus.SC_ACCEPTED, 119, 162, 388, 848, 120}, new int[]{105, 432, 276, 154, 48, 792, 336, 134, 49, 608, 464, 166, 51, 140, 224, 960}, new int[]{96, 85, 392, 444, 146, 81, 432, 192, 154, 103, 920, 388, 144, 49, 216, 460}, new int[]{328, 240, 50, 920, 280, 104, 108, 880, 348, 158, 116, 848, HttpStatus.SC_FAILED_DEPENDENCY, 226, 110, 198}, new int[]{HttpStatus.SC_BAD_REQUEST, HttpStatus.SC_REQUEST_TIMEOUT, 156, 51, 872, 264, 166, 101, 800, 336, 150, 105, 440, 396, 198, 74}};
    private final String accessTokenUrl;

    public C2014b(String str) {
        this.accessTokenUrl = str;
    }

    public String generateConsumerSecret() {
        return descrambleConsumerSecret(this.scrambledConsumerKey, 16, 11, 9);
    }

    private String descrambleConsumerSecret(int[][] iArr, int i, int i2, int i3) {
        int i4 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer(this.accessTokenUrl.toString());
        while (stringBuffer.length() < i * 2) {
            char c = (char) iArr[i3][i2];
            stringBuffer.append((char) (iArr[i3][i2] >> (m6502a(i2, i3) % 4)));
            stringBuffer.append(c);
            i2 = m6503a(iArr, i2, i3);
            i3 = m6505b(iArr, i2, i3);
        }
        stringBuffer2.setLength(0);
        while (i4 < stringBuffer.length()) {
            stringBuffer2.append(i4 % 2 == 0 ? Character.valueOf(stringBuffer.charAt(i4)) : "");
            i4++;
        }
        return stringBuffer2.toString();
    }

    private int m6503a(int[][] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i3 + 1;
            i3 = ((i3 + iArr[i2][i4]) + i4) % iArr[i2].length;
            if (i3 != i) {
                return i3;
            }
            i4 = i3;
            i3 = i5;
        }
    }

    private int m6505b(int[][] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = i3 + 1;
            i3 = ((i3 + iArr[i4][i]) + i4) % iArr.length;
            if (i3 != i2) {
                return i3;
            }
            i4 = i3;
            i3 = i5;
        }
    }

    private int m6502a(int i, int i2) {
        return i2 > i ? i2 - i : i - i2;
    }
}
