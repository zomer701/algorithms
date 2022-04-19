public class TrappingRainWater
{
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int result = 0;
        int maxLine = 0;

        int index = 0;
        while (index < height.length - 1)
        {
            int value = height[index];
            int next = height[index + 1];

            maxLine = Math.max(maxLine, value);

            if (next > value)
            {
                int val = Math.min(maxLine, next);

                int indexInner = index;

                while (height[indexInner] < val)
                {
                    result += val -  height[indexInner];
                    height[indexInner] = val;
                    indexInner--;
                }
            }

            index++;
        }

        return result;
    }
}
