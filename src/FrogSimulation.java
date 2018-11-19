public class FrogSimulation
{
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        return (int)(Math.random()* 21) + -5;
    }

    public boolean simulate()
    {
        int curD = 0;
        int hopD = 0;
        String hops = "";
        int[] arr = new int[maxHops];
        for(int i = 0;i < maxHops;i++)
        {
            hopD = hopDistance();
            curD += hopD;
            arr[i] = hopD;
            if(curD<0)
            {
                for(int j=0;j<i+1;j++)
                {
                    hops += arr[j] + " ";
                }
                System.out.println("Goal : " + goalDistance + " Hops: " + hops + " Failed Reached Negative Distance");
                return false;
            }
            if(curD>=goalDistance)
            {
                for(int j=0;j<i+1;j++)
                {
                    hops += arr[j] + " ";
                }
                System.out.println("Goal : " + goalDistance + " Hops: " + hops + " Success Final Distance: " + curD);
                return true;
            }
        }
        for(int j=0;j<maxHops;j++)
        {
            hops += arr[j] + " ";
        }
        System.out.println("Goal : " + goalDistance + " Hops: " + hops + " Failed Final Distance: " + curD);
        return false;
    }

    public double runSimulations(int num)
    {
        int tTtotal = 0;
        for(int i=0;i<num;i++)
        {
            if(simulate())
            {
                tTtotal++;
            }
        }
        return (double)tTtotal/num;
    }

}
