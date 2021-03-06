/* The following code was generated by JFlex 1.4.3 on 25/06/14 10:44 */

package Telas;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 25/06/14 10:44 from the specification file
 * <tt>C:/Users/Sub_Zero/workspace2/TradutorPortugol/src/Telas/padraoFinalLexico.flex</tt>
 */
class Lexer {
	
	public int op, pos;
    public int num;
	public Tabela hash = new Tabela();
	public Arquivo arq = new Arquivo();
	
	public void setNum (int num){
		this.num = num;		
	}
	
	public int getNum (){
		return this.num;		
	}

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\7\0\2\47\1\2\1\1\1\26\1\52\1\27\22\0\1\51\1\47"+
    "\1\44\4\47\1\0\1\35\1\34\1\35\1\37\1\35\1\32\1\33"+
    "\1\36\12\31\1\35\1\35\1\41\1\42\1\40\1\50\1\47\32\30"+
    "\1\35\1\35\1\35\1\0\1\47\1\0\1\3\1\30\1\6\1\14"+
    "\1\5\1\22\1\24\1\21\1\13\2\30\1\20\1\23\1\12\1\10"+
    "\1\25\1\16\1\11\1\7\1\4\1\17\1\15\4\30\1\46\1\47"+
    "\1\45\7\0\1\26\34\0\2\47\3\0\2\47\1\0\1\47\1\0"+
    "\1\47\5\0\2\47\5\0\2\47\5\0\4\47\4\0\3\47\1\0"+
    "\3\47\3\0\4\47\3\0\3\47\4\0\4\47\3\0\4\47\1\0"+
    "\3\47\3\0\4\47\3\0\3\47\u1f1d\0\1\47\2\0\1\43\1\47"+
    "\12\0\2\26\udfd6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\2\1\3\33\1\1\4"+
    "\2\1\2\4\1\1\1\5\3\1\2\5\21\1\1\6"+
    "\1\1\2\6\1\1\3\7\1\1\2\7\2\1\3\10"+
    "\1\1\1\0\2\1\2\4\1\11\1\1\2\5\2\1"+
    "\1\12\21\1\1\13\1\1\1\14\2\0\1\14\5\15"+
    "\1\0\2\10\1\0\1\16\1\10\24\1\1\17\1\1"+
    "\2\17\2\15\2\20\1\10\1\16\21\1\1\21\4\1"+
    "\1\22\1\1\2\22\7\1\2\22\1\23\5\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[197];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\254\0\327\0\u0102\0\u012d"+
    "\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a\0\u0285"+
    "\0\u02b0\0\u02db\0\u0306\0\u0331\0\u035c\0\u0387\0\u03b2\0\u03dd"+
    "\0\u0408\0\u0433\0\u045e\0\u0489\0\u04b4\0\u04df\0\u050a\0\u0535"+
    "\0\u0560\0\u058b\0\u05b6\0\u05e1\0\u060c\0\u058b\0\u0637\0\u0662"+
    "\0\u05b6\0\u068d\0\u06b8\0\u06e3\0\u058b\0\u070e\0\u0739\0\u0764"+
    "\0\u078f\0\u07ba\0\u07e5\0\u0810\0\u083b\0\u0866\0\u0891\0\u08bc"+
    "\0\u08e7\0\u0912\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9\0\u05b6"+
    "\0\u0a14\0\126\0\u0a3f\0\u0a6a\0\u05b6\0\126\0\u0a95\0\u0ac0"+
    "\0\u0aeb\0\u0b16\0\u0b41\0\u0b6c\0\u0b97\0\126\0\u0bc2\0\u0bed"+
    "\0\u0aeb\0\u0c18\0\u0c43\0\126\0\u0c6e\0\u05b6\0\u0c99\0\126"+
    "\0\u0cc4\0\u0cef\0\u0d1a\0\u05b6\0\u0d45\0\u0d70\0\u0d9b\0\u0dc6"+
    "\0\u0df1\0\u0e1c\0\u0e47\0\u0e72\0\u0e9d\0\u0ec8\0\u0ef3\0\u0f1e"+
    "\0\u0f49\0\u0f74\0\u0f9f\0\u0fca\0\u0ff5\0\u05b6\0\u1020\0\u05b6"+
    "\0\u104b\0\u1076\0\u0aeb\0\u0aeb\0\126\0\u10a1\0\u05b6\0\u10cc"+
    "\0\u0b97\0\u05b6\0\u10f7\0\u1122\0\u0b97\0\u114d\0\u1178\0\u11a3"+
    "\0\u11ce\0\u11f9\0\u1224\0\u124f\0\u127a\0\u12a5\0\u12d0\0\u12fb"+
    "\0\u1326\0\u1351\0\u137c\0\u13a7\0\u13d2\0\u13fd\0\u1428\0\u1453"+
    "\0\u147e\0\u14a9\0\u05b6\0\u14d4\0\126\0\u14ff\0\u152a\0\u1555"+
    "\0\u0aeb\0\u05b6\0\u1580\0\u05b6\0\u15ab\0\u15d6\0\u1601\0\u162c"+
    "\0\u1657\0\u1682\0\u16ad\0\u16d8\0\u1703\0\u172e\0\u1759\0\u1784"+
    "\0\u17af\0\u17da\0\u1805\0\u1830\0\u185b\0\u05b6\0\u1886\0\u18b1"+
    "\0\u18dc\0\u1907\0\u05b6\0\u1932\0\u058b\0\u195d\0\u1988\0\u19b3"+
    "\0\u19de\0\u1a09\0\u1a34\0\u1a5f\0\u1a8a\0\126\0\u1ab5\0\u05b6"+
    "\0\u1ae0\0\u1b0b\0\u1b36\0\u1b61\0\u1b8c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[197];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\24\3\1\6\21\3\1\5\1\6"+
    "\1\3\1\4\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\2\23\1\24"+
    "\1\23\1\25\1\26\1\23\1\27\1\3\1\6\1\23"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\31\1\36"+
    "\1\37\2\34\1\40\1\3\1\41\2\3\1\5\1\6"+
    "\1\3\1\0\51\3\1\0\1\4\25\0\1\4\22\0"+
    "\1\4\1\3\1\0\1\5\46\3\1\5\2\3\1\4"+
    "\25\3\1\6\22\3\1\6\1\3\1\0\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\2\23\1\24\1\23\1\25\1\26\1\23"+
    "\1\27\2\3\1\23\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\31\1\36\1\37\2\34\1\40\1\3\1\41"+
    "\2\3\1\5\1\3\1\42\1\43\1\44\1\23\1\45"+
    "\21\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\10\23\1\50\12\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\51\1\52\4\23\1\53\2\23\1\54"+
    "\13\23\1\55\1\56\2\23\20\42\1\55\1\42\1\43"+
    "\1\44\1\57\4\23\1\60\15\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\2\23\1\61\20\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\14\23\1\62\6\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\2\23\1\63\20\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\1\64\22\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\7\23\1\65\13\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\2\23\1\62\5\23\1\66\12\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\1\67\1\23\1\70\20\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\23\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\2\23\1\71\2\23"+
    "\1\72\15\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\1\73\7\23\1\74\12\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\5\23\1\75"+
    "\15\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\1\76\5\23\1\77\14\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\3\1\100\1\101\23\3\1\102\1\103"+
    "\1\3\1\30\1\3\1\104\16\3\1\102\1\3\1\105"+
    "\1\34\23\3\1\106\1\107\1\3\1\30\20\3\1\106"+
    "\1\3\1\105\1\34\23\3\1\106\1\107\3\3\1\34"+
    "\16\3\1\106\1\3\1\105\1\34\23\3\1\106\1\107"+
    "\1\3\1\110\20\3\1\106\1\3\1\105\1\34\23\3"+
    "\1\106\1\107\22\3\1\106\1\3\1\111\1\35\23\41"+
    "\1\106\1\112\6\41\1\113\4\41\2\3\1\114\1\3"+
    "\1\41\1\113\1\41\1\106\1\3\1\105\1\34\23\3"+
    "\1\106\1\107\12\3\1\34\7\3\1\106\1\3\1\105"+
    "\1\34\23\3\1\106\1\107\2\3\1\34\5\3\1\34"+
    "\1\3\1\34\7\3\1\106\1\3\1\115\24\40\1\116"+
    "\1\117\13\40\1\3\1\120\5\40\1\116\1\3\1\121"+
    "\24\41\1\3\7\41\1\113\4\41\2\3\1\114\1\3"+
    "\1\41\1\113\1\41\2\3\1\0\1\3\23\122\2\3"+
    "\1\122\22\3\53\0\1\3\1\43\1\123\23\122\1\124"+
    "\1\125\1\122\21\3\1\124\1\42\1\43\1\44\2\23"+
    "\1\62\20\23\1\46\1\47\2\23\20\42\1\46\1\3"+
    "\1\126\1\3\23\122\2\3\1\122\22\3\1\42\1\43"+
    "\1\44\22\23\1\64\1\46\1\47\2\23\20\42\1\46"+
    "\1\3\1\51\1\127\23\122\1\130\1\131\1\122\21\3"+
    "\1\130\1\42\1\43\1\44\3\23\1\132\17\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\1\23"+
    "\1\17\11\23\1\133\7\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\3\1\134\1\3\23\122\2\3\1\122\22\3"+
    "\1\42\1\43\1\44\4\23\1\64\1\23\1\135\14\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\7\23\1\136\13\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\51\1\52\7\23\1\17\13\23\1\55\1\56"+
    "\2\23\20\42\1\55\1\42\1\51\1\52\23\23\1\55"+
    "\1\56\2\23\20\42\1\55\1\42\1\43\1\44\1\137"+
    "\1\140\17\23\1\141\1\142\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\5\23\1\62\15\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\1\23"+
    "\1\143\6\23\1\144\12\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\12\23\1\62\10\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\6\23"+
    "\1\62\14\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\1\23\1\145\4\23\1\146\14\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\10\23"+
    "\1\147\12\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\21\23\1\150\1\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\3\23\1\147\11\23"+
    "\1\151\5\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\20\23\1\152\2\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\11\23\1\153\11\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\4\23\1\154\1\23\1\147\14\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\5\23\1\155\15\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\3\1\100\1\101"+
    "\23\3\1\102\1\103\22\3\1\102\1\3\1\156\52\3"+
    "\1\0\27\3\1\157\22\3\1\160\52\3\1\100\1\101"+
    "\23\3\1\102\1\103\1\3\1\110\20\3\1\102\1\0"+
    "\25\121\1\0\7\121\1\161\4\121\2\0\1\162\1\0"+
    "\1\121\1\161\1\121\1\0\1\3\1\163\24\41\1\3"+
    "\7\41\1\113\4\41\2\3\1\114\1\3\1\41\1\113"+
    "\1\41\2\3\1\164\1\113\23\41\1\165\1\166\6\41"+
    "\1\113\4\41\2\3\1\114\1\3\1\41\1\113\1\41"+
    "\1\165\1\3\1\167\1\114\23\3\1\165\1\170\22\3"+
    "\1\165\1\0\1\115\24\171\1\172\1\173\13\171\1\0"+
    "\1\174\5\171\1\172\1\3\1\175\24\40\1\116\1\117"+
    "\13\40\1\3\1\120\5\40\1\116\1\3\1\172\1\120"+
    "\23\3\1\116\1\176\22\3\1\116\1\3\1\43\1\123"+
    "\23\122\1\124\1\125\2\122\20\3\1\124\1\3\1\43"+
    "\1\123\23\3\1\124\1\125\22\3\1\124\1\3\1\126"+
    "\52\3\1\51\1\127\23\3\1\130\1\131\22\3\1\130"+
    "\1\3\1\134\51\3\1\42\1\43\1\44\5\23\1\177"+
    "\1\200\14\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\14\23\1\201\6\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\1\202\22\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\1\23"+
    "\1\203\21\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\15\23\1\62\5\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\5\23\1\204\15\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\10\23\1\205\12\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\10\23\1\206\12\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\2\23\1\207"+
    "\20\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\3\23\1\210\17\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\5\23\1\67\15\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\11\23"+
    "\1\211\11\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\1\62\22\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\10\23\1\212\12\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\4\23"+
    "\1\213\16\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\51\1\52\1\214\1\23\1\215\1\23\1\45\1\23"+
    "\1\216\11\23\1\217\1\23\1\220\1\55\1\56\2\23"+
    "\20\42\1\55\1\42\1\51\1\52\14\23\1\221\6\23"+
    "\1\55\1\56\2\23\20\42\1\55\1\42\1\43\1\44"+
    "\4\23\1\64\16\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\21\23\1\222\1\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\3\1\223\1\224\23\3\1\225"+
    "\1\226\1\3\1\157\20\3\1\225\1\0\1\164\1\161"+
    "\23\121\1\167\1\227\6\121\1\161\4\121\2\0\1\162"+
    "\1\0\1\121\1\161\1\121\1\167\1\0\1\167\1\162"+
    "\23\0\1\167\1\230\22\0\1\167\1\3\1\231\24\41"+
    "\1\3\7\41\1\113\4\41\2\3\1\114\1\3\1\41"+
    "\1\113\1\41\2\3\1\232\51\3\1\0\1\175\24\171"+
    "\1\172\1\173\13\171\1\0\1\174\5\171\1\172\1\0"+
    "\1\172\1\174\23\0\1\172\1\233\22\0\1\172\1\3"+
    "\1\234\51\3\1\42\1\43\1\44\15\23\1\235\5\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\2\23\1\236\20\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\1\237\22\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\3\23\1\240\17\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\6\23\1\241\14\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\6\23\1\242\14\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\4\23\1\243"+
    "\16\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\1\23\1\147\21\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\10\23\1\244\12\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\10\23"+
    "\1\64\12\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\1\245\22\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\3\23\1\64\17\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\5\23"+
    "\1\246\15\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\15\23\1\247\5\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\4\23\1\250\2\23"+
    "\1\251\13\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\2\23\1\252\20\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\5\23\1\253\15\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\1\254\22\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\15\23\1\64\5\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\6\23\1\255\14\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\3\1\223\1\224"+
    "\23\3\1\225\1\226\22\3\1\225\1\3\1\256\51\3"+
    "\1\0\1\231\24\121\1\0\7\121\1\161\4\121\2\0"+
    "\1\162\1\0\1\121\1\161\1\121\2\0\1\232\52\0"+
    "\1\234\51\0\1\42\1\43\1\44\16\23\1\147\4\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\12\23\1\147\10\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\7\23\1\257\13\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\1\23\1\260"+
    "\21\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\1\261\22\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\7\23\1\45\13\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\1\23\1\244"+
    "\21\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\6\23\1\64\14\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\11\23\1\262\11\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\263\1\264\23\23"+
    "\1\265\1\266\2\23\20\42\1\265\1\42\1\43\1\44"+
    "\21\23\1\267\1\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\3\23\1\270\17\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\13\23\1\133"+
    "\7\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\21\23\1\141\1\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\11\23\1\271\11\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\6\23"+
    "\1\147\14\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\1\272\22\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\1\23\1\64\21\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\2\23"+
    "\1\273\20\23\1\46\1\47\2\23\20\42\1\46\1\42"+
    "\1\43\1\44\6\23\1\210\14\23\1\46\1\47\2\23"+
    "\20\42\1\46\1\42\1\43\1\44\2\23\1\274\20\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\3\1\263\1\275"+
    "\23\122\1\276\1\277\1\122\21\3\1\276\1\3\1\300"+
    "\1\3\23\122\2\3\1\122\22\3\1\42\1\43\1\44"+
    "\5\23\1\301\15\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\5\23\1\177\15\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\14\23\1\221"+
    "\6\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\20\23\1\147\2\23\1\46\1\47\2\23\20\42"+
    "\1\46\1\42\1\43\1\44\6\23\1\45\14\23\1\46"+
    "\1\47\2\23\20\42\1\46\1\42\1\43\1\44\10\23"+
    "\1\302\12\23\1\46\1\47\2\23\20\42\1\46\1\3"+
    "\1\263\1\275\23\3\1\276\1\277\22\3\1\276\1\3"+
    "\1\300\51\3\1\42\1\43\1\44\6\23\1\303\14\23"+
    "\1\46\1\47\2\23\20\42\1\46\1\42\1\43\1\44"+
    "\6\23\1\213\14\23\1\46\1\47\2\23\20\42\1\46"+
    "\1\42\1\43\1\44\10\23\1\304\12\23\1\46\1\47"+
    "\2\23\20\42\1\46\1\42\1\43\1\44\1\23\1\305"+
    "\21\23\1\46\1\47\2\23\20\42\1\46\1\42\1\43"+
    "\1\44\20\23\1\64\2\23\1\46\1\47\2\23\20\42"+
    "\1\46";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7095];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\40\1\1\11\5\1\1\11\26\1\1\11\4\1"+
    "\1\11\13\1\1\0\4\1\1\11\5\1\1\11\21\1"+
    "\1\11\1\1\1\11\2\0\4\1\1\11\1\1\1\0"+
    "\1\11\1\1\1\0\26\1\1\11\6\1\1\11\1\1"+
    "\1\11\21\1\1\11\4\1\1\11\14\1\1\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[197];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 206) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      if (zzMarkedPosL > zzStartRead) {
        switch (zzBufferL[zzMarkedPosL-1]) {
        case '\n':
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          zzAtBOL = true;
          break;
        case '\r': 
          if (zzMarkedPosL < zzEndReadL)
            zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          else if (zzAtEOF)
            zzAtBOL = false;
          else {
            boolean eof = zzRefill();
            zzMarkedPosL = zzMarkedPos;
            zzEndReadL = zzEndRead;
            zzBufferL = zzBuffer;
            if (eof) 
              zzAtBOL = false;
            else 
              zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          }
          break;
        default:
          zzAtBOL = false;
        }
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      if (zzAtBOL)
        zzState = ZZ_LEXSTATE[zzLexicalState+1];
      else
        zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 19: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 6;
          }
        case 20: break;
        case 18: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 6;
          }
        case 21: break;
        case 4: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); pos = hash.funcaohashing(num); num =  hash.inserir(pos, num, yytext()); return 1;
          }
        case 22: break;
        case 9: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); pos = hash.funcaohashing(num); num =  hash.inserir(pos, num, yytext()); return 1;
          }
        case 23: break;
        case 15: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 4;
          }
        case 24: break;
        case 17: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 4;
          }
        case 25: break;
        case 1: 
          { /*System.err.printf(" - Token Inv�lido |%s|\n", yytext());*/ arq.arquivoErros(" - Token Inv�lido"+"  |"+yytext().trim()+"|\n"); return 0;
          }
        case 26: break;
        case 8: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 7;
          }
        case 27: break;
        case 14: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 7;
          }
        case 28: break;
        case 2: 
          { /* nova linha, retrocesso e \f */
          }
        case 29: break;
        case 13: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /* coment�rio */
          }
        case 30: break;
        case 16: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /* coment�rio */
          }
        case 31: break;
        case 5: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 2;
          }
        case 32: break;
        case 10: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 2;
          }
        case 33: break;
        case 6: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 5;
          }
        case 34: break;
        case 11: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 5;
          }
        case 35: break;
        case 3: 
          { /* espa�o e tabula��o */
          }
        case 36: break;
        case 7: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 3;
          }
        case 37: break;
        case 12: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { /*System.out.printf(" - Token Encontrado |%s|\n", yytext());*/ arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 3;
          }
        case 38: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
