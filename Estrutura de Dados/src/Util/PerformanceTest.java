package Util;

public class PerformanceTest {
	private static final long MEGABYTE = 1024L * 1024L;
	
	public static long bytesToMegabytes(long bytes){
		return bytes/MEGABYTE;
	}
	public static long getMemoryUsedNow(){
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		
		long freeMemory = runtime.freeMemory();//15656456, 15415736
		long totalMemory = runtime.totalMemory();//16318464, 16318464
		
		return totalMemory - freeMemory;
	}
}
