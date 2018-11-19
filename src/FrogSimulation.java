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
        return (int)(Math.random()* 61) + -30;
    }

    public boolean simulate()
    {
        int curD = 0;
        int hopD = 0;
        for(int i = 0;i < maxHops;i++)
        {
            hopD = hopDistance();
            curD += hopD;
            if(curD<0)
            {
                return false;
            }
            if(curD>=goalDistance)
            {
                return true;
            }
        }
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
