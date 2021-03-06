class StringCheaker
{
  public static int check(String str1, String str2)
  {
    //get string length of two strings
    int stringLength1 = str1.length();
    int stringLength2 = str2.length();
    
    //find the mininmum length 
    int minLength = Math.min(stringLength1,stringLength2);
    
    //loop it to find left and right string
    for(int i=0;i<minLength;i++)
    {
      //get two ASCII values of particular characters
      int chr1 = (int) str1.charAt(i);
      int chr2 = (int) str2.charAt(i);
      
      //chr1 = B ; chr2 = A
      if(chr1 > chr2 )
      {
        return 1;
      }else if(chr1 < chr2)
        return -1;
      else
        continue;
    }
    
    
    //if minString is subset of maxString do this
    if(stringLength1 > stringLength2)
      return 1;
    else
      return -1;
  }
}

/* Note : return 1 for add left side
 *        return -1 for add rigth side
 * 
 * if(1) => goto left
 * if(-1)=> goto right
 * 
 * */
