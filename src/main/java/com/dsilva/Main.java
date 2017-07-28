package com.dsilva;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.lang.String;

/**
 * Get System Informaition
 */
public class Main {
    private static final String HELP = "help";
    private static final String MEMORY = "m";
    private static final String FREE_MEMORY = "fm";
    private static final String USED_MEMORY = "um";
    private static final String OS = "os";
    private static final String IP = "ip";
    private static final String HARDDISK = "hd";
    private static final String ALL = "all";
    private static final String DASH = "-";
    private static Runtime runtime;
    private static InetAddress ip;


    public static void main(String[] args) throws UnknownHostException {
        runtime = Runtime.getRuntime();
        com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        SystemCalls system = new SystemCalls();

        try {


            if (args[0].split(DASH)[1].equals(HELP)) {
                System.out.println(system.getHelp());
            } else if (args[0].split(DASH)[1].equals(MEMORY)) {
                System.out.println("Total Memory : " + system.getTotalMemory() + "MB");

            } else if (args[0].split(DASH)[1].equals(FREE_MEMORY)) {
                System.out.println("Free Memory : " + system.getFreeMemory());
            } else if (args[0].split(DASH)[1].equals(USED_MEMORY)) {
                System.out.println("Used Memory : " + system.getUsedMemory());
            } else if (args[0].split(DASH)[1].equals(OS)) {
                System.out.println("OS Name\t\t\t: " + system.getOSName());
                System.out.println("OS Version\t\t: " + system.getOSVersion());
                System.out.println("OS Architecture\t\t: " + system.getOSArchitecture());
                System.out.println("Available processors\t: " + system.getAvailableProcessors());
            } else if (args[0].split(DASH)[1].equals(IP)) {
                System.out.println("IP addrres : " + system.getIP());
            } else if (args[0].split(DASH)[1].equals(HARDDISK)) {
                system.printHardDiskDetails();
            } else if (args[0].split(DASH)[1].equals(ALL)) {
                System.out.println("Total Memory : " + system.getTotalMemory() + "MB");
                System.out.println("Used Memory : " + system.getUsedMemory());
                System.out.println("Free Memory : " + system.getFreeMemory());
                System.out.println("OS Name\t\t\t: " + system.getOSName());
                System.out.println("OS Version\t\t: " + system.getOSVersion());
                System.out.println("OS Architecture\t\t: " + system.getOSArchitecture());
                System.out.println("Available processors\t: " + system.getAvailableProcessors());
                System.out.println("IP addrres : " + system.getIP());
                system.printHardDiskDetails();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid arguments. \"Main -help\" for help");
        }

    }
}
