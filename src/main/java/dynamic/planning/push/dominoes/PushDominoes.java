package dynamic.planning.push.dominoes;

/*

 */

public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes pd = new PushDominoes();
        System.out.println(pd.pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        char[] domiArray = dominoes.toCharArray();
        boolean[] isPushed = new boolean[domiArray.length];

        boolean pushedFound = false;
        for(int i = 0; i < domiArray.length; i++) {
            if(domiArray[i] != '.') {
                isPushed[i] = true;
                pushedFound = true;
            }
        }

        while(pushedFound) {
            System.out.println(new String(domiArray));
            pushedFound = false;
            for(int i = 0; i < domiArray.length; i++) {
                if(isPushed[i] && domiArray[i] == 'L') {
                    isPushed[i] = false;
                    if(i > 0 && domiArray[i - 1] == '.') {
                        if(i > 1) {
                            if(isPushed[i - 2] && domiArray[i - 2] == 'R') {

                            } else {
                                isPushed[i - 1] = true;
                                pushedFound = true;
                                domiArray[i - 1] = 'L';
                            }
                        } else {
                            isPushed[i - 1] = true;
                            pushedFound = true;
                            domiArray[i - 1] = 'L';
                        }
                    }
                }
            }
            System.out.println(new String(domiArray));
            for(int i = domiArray.length - 1; i >=0; i--) {
                if(isPushed[i] && domiArray[i] == 'R') {
                    isPushed[i] = false;
                    if((i < domiArray.length - 1) && domiArray[i + 1] == '.') {
                        if(i < domiArray.length - 2) {
                            if(!isPushed[i + 2] && domiArray[i + 2] == 'L') {

                            } else {
                                isPushed[i + 1] = true;
                                pushedFound = true;
                                domiArray[i + 1] = 'R';
                            }
                        } else {
                            isPushed[i + 1] = true;
                            pushedFound = true;
                            domiArray[i + 1] = 'R';
                        }
                    }
                }
            }
        }

        return new String(domiArray);
    }
}
