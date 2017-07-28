package com.dsilva;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Himasha on 7/27/2017.
 */
public class SystemCalls implements SystemCallMethods {
    InetAddress ip;
    Runtime runtime = Runtime.getRuntime();
    com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    FileSystemView fsv = FileSystemView.getFileSystemView();

    public String getHelp() {
        return "usage: java SystemInfo [options]\n" +
                "options : \n" +
                "-m\tShow total memory\n" +
                "-fm\tShow free memory\n" +
                "-um\tShow used memory\n" +
                "-os\tShow OS info\n" +
                "-ip\tShow IP address\n" +
                "-hd\tShow HardDisk Details";
    }

    public String getTotalMemory() {

        return mxbean.getTotalPhysicalMemorySize() / (1024 * 1024) + "";
    }

    public String getFreeMemory() {

        return mxbean.getFreePhysicalMemorySize() / (1024 * 1024) + "";
    }

    public String getUsedMemory() {
        return (mxbean.getTotalPhysicalMemorySize() - mxbean.getFreePhysicalMemorySize()) / (1024 * 1024) + "";
    }

    public String getOSName() {
        return System.getProperty("os.name");
    }

    public String getOSVersion() {
        return System.getProperty("os.version");
    }

    public String getOSArchitecture() {
        return System.getProperty("os.arch");
    }

    public String getAvailableProcessors() {
        return runtime.availableProcessors() + "";
    }

    public String getIP() {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip.getHostAddress();
    }

    public void printHardDiskDetails() {
        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println("Drive Letter: " + aDrive);
                System.out.println("\tType: " + fsv.getSystemTypeDescription(aDrive));
                System.out.println("\tTotal space: " + aDrive.getTotalSpace() / (1024 * 1024 * 1024) + "GB");
                System.out.println("\tFree space: " + aDrive.getFreeSpace() / (1024 * 1024 * 1024) + "GB");
                System.out.println();
            }
        }
    }
}
