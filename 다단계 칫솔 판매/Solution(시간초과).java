import java.util.*;


class Main {
    static String[][] tree; // [위에놈][아랫놈]=[referral][enroll]
    static int[] result;
    static int l;
    public static void main(String[] args){
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        result = new int[enroll.length];
        for(int i=0; i<result.length; i++){
            result[i]=0;
        }
        
        l = 0;
        for(int i=0; i<referral.length; i++){
            if(!referral[i].equals("-")){
                l+=1;
            }
        }
        tree = new String[l][2];
        int c=0;
        for(int i=0; i<referral.length; i++){
            if(!referral[i].equals("-")){
                tree[c][0]=referral[i];
                tree[c][1]=enroll[i];
                c+=1;
            }
        }
        
        for(int i=0; i<seller.length; i++){
            boolean check=false;
            for(int j=0; j<l; j++){
                if(seller[i].equals(tree[j][1])){
                    Trees(enroll,j,amount[i]*100);
                    check=true;
                }
            }
            if(!check){
                for(int j=0; j<enroll.length; j++){
                    if(enroll[j].equals(seller[i])){
                        result[j]+=(amount[i]*100)-((amount[i]*100)/10);
                    }
                }
            }
        }
            
        
        for(int i=0; i<result.length; i++){
            System.out.printf("%d ",result[i]);
        }
    }
    
    
    public static void Trees(String[] enroll, int j,int amounter){
        int z1=0;
        for(int i=0; i<enroll.length; i++){
            if(enroll[i].equals(tree[j][1])){
                if(amounter/10>0){
                    result[i]+=amounter-(amounter/10);
                    z1=amounter/10;
                }
                else{
                    result[i]+=amounter;
                }
                break;
            }
        }
        
        // for(int i=0; i<enroll.length; i++){
        //     if(enroll[i].equals(tree[j][0])){
        //         if(amounter/10>0){
        //             result[i]+=amounter*0.1;
        //         }
        //     }
        // }
        
        if(z1!=0){
            boolean ch = false;
            for(int i=0; i<l; i++){
                if(tree[j][0].equals(tree[i][1])){
                    Trees(enroll,i,z1);
                    ch=true;
                    break;
                }
            }
            if(!ch){
                for(int i=0; i<enroll.length; i++){
                    if(tree[j][0].equals(enroll[i])){
                        if(z1/10>0){
                            result[i]+=z1-(z1/10);
                        }
                        else{
                            result[i]+=z1;
                        }
                        break;
                    }
                }
            }
        }
        
        return;
    }
}