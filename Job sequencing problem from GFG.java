class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int jobs[][] = new int[n][2];
        int max_deadline = -1;

        for(int i=0;i<n;i++){
            jobs[i][0]=deadline[i];
            jobs[i][1]=profit[i];
            max_deadline=deadline[i]
        }
        Arrays.sort(jobs,(a,b)->b[1]-a[1]);
        int slots=new int[max_deadline+1];
        int job_cnt=0,tot_profit=0;
        for(int i=0;i<n;i++){
            int j = jobs[i][0];
            while(j>0 && slots[j]==1){
                j--;
            }
            if(j>0){
                slots[j]=1;
                job_cnt++;
                if(job_cnt)
                tot_profit+=jobs[i][1];
            }
        }
        return new ArrayLish<Integer>(Arrays.asList(job_cnt,tot_profit));
    }
}
