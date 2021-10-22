package regex;

/**
 * 解析字符串，从字符串中提取字符串
 * 处理单行
 * 假设调用者足够细心。
 * "ac {}{"
 * */
public class StringGetByRegex {
    String left;
    String right;
    int ls;
    int rs;
    public static int charCounter(String s,char cr){
        int count = 0;
        for(char c:s.toCharArray()){
            if(c==cr){
                count++;
            }
        }
        return count;
    }
  /**
   * String s = "public class TestStringGetByRegex "; String regex = "c class {} ";
   * System.out.println(new StringGetByRegex().getThatOne(s,regex));   ->TestStringGetByRegex<-
   * 对于空格有一定的宽容，如果regex在}后面只有一个空格，将会直接返回...trim()
   *
   */
  public String getThatOne(String s, String regex) {
        if(charCounter(regex,'{')>=1){
            ls = regex.indexOf('{');
            System.out.println("ls "+ls);
            rs = ls+1;
            for(char c:regex.substring(ls+1).toCharArray()){
                if(c==' '){
                    rs++;
                }else if(c!='}'){
                    rs++;
                    System.out.println("error,please check the syntax");
                }else{
                    break;
                }
            }
        }
        int sls = s.indexOf(regex.substring(0,ls))+ls;//end->begin index
        System.out.println("rs "+rs);
        if(rs==regex.length()-1){
            return s.substring(sls);
        }
        String endstr = regex.substring(rs+1);
//        System.out.println("endstr "+endstr);
        if(endstr.equals(" ")){
            return s.substring(sls).trim();
        }
        int ors = s.indexOf(endstr,sls);
        return s.substring(sls,ors);
    }
}
