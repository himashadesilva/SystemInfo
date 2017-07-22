package com.dsilva;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.lang.String;

/**
 * Get System Informaition
 *
 */
public class Main
{
    private static final String HELP = "help";
    private static final String MEMORY = "m";
    private static final String FREE_MEMORY = "fm";
    private static final String USED_MEMORY = "um";
    private static final String OS = "os";
    private static final String IP = "ip";
    private static final String HARDDISK = "hd";
    private static final String DASH = "-";
    private static Runtime runtime;
    private static InetAddress ip;


    public static void main( String[] args ) throws UnknownHostException {
        runtime = Runtime.getRuntime();
        com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


        if(args[0].split(DASH)[1].equals(HELP)){
            System.out.println("usage: java SystemInfo [options]");
            System.out.print("-m\tShow total memory\n" +
                    "-fm\tShow free memory\n" +
                    "-um\tShow used memory\n" +
                    "-os\tShow OS info\n" +
                    "-ip\tShow IP address\n" +
                    "-hd\tShow HardDisk Details");
        }
        else if(args[0].split(DASH)[1].equals(MEMORY)){
            System.out.println("Total memory : "+mxbean.getTotalPhysicalMemorySize()/(1024*1024)+"MB`");
        }
        else if(args[0].split(DASH)[1].equals(FREE_MEMORY)){
            System.out.println("Free memory : "+mxbean.getFreePhysicalMemorySize()/(1024*1024)+"MB`");
        }
        else if(args[0].split(DASH)[1].equals(USED_MEMORY)){
            System.out.println("Used memory : "+(mxbean.getTotalPhysicalMemorySize()-mxbean.getFreePhysicalMemorySize())/(1024*1024)+"MB`");
        }
        else if(args[0].split(DASH)[1].equals(OS)){
            System.out.println("OS name :\t"+System.getProperty("os.name")+"\n" +
                    "OS version :\t"+System.getProperty("os.version")+"\n"+
                    "OS architecture :\t"+System.getProperty("os.arch")+"\n" +
                    "Available processors :\t"+runtime.availableProcessors());

        }
        else if(args[0].split(DASH)[1].equals(IP)){
            ip = InetAddress.getLocalHost();
            System.out.println("IP address :\t"+ip.getHostAddress());

        }
        else if(args[0].split(DASH)[1].equals(HARDDISK)){
            FileSystemView fsv = FileSystemView.getFileSystemView();

            File[] drives = File.listRoots();
            if (drives != null && drives.length > 0) {
                for (File aDrive : drives) {
                    System.out.println("Drive Letter: " + aDrive);
                    System.out.println("\tType: " + fsv.getSystemTypeDescription(aDrive));
                    System.out.println("\tTotal space: " + aDrive.getTotalSpace()/(1024*1024*1024)+"GB");
                    System.out.println("\tFree space: " + aDrive.getFreeSpace()/(1024*1024*1024)+"GB");
                    System.out.println();
                }
            }
                    }

    }
}
