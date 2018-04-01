import core.Publisher;
import core.Receiver;
import service.PropertiesService;
import table.MemCacheTable;
import table.model.RoutingTable;

import java.io.IOException;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class Main {
    public static void main (String[] args) {

        PropertiesService properties = new PropertiesService();


        String netWorkAddress_1 = properties.getNetWorkAddress_1();
        String mask_1 = properties.getMask_1();
        String defaultGetWay_1 = properties.getDefaultGetWay_1();
        String interf_1 = properties.getInterf_1();
        String group_1 = properties.getGroup_1();

        String netWorkAddress_2 = properties.getNetWorkAddress_2();
        String mask_2 = properties.getMask_2();
        String defaultGetWay_2 = properties.getDefaultGetWay_2();
        String interf_2 = properties.getInterf_2();
        String group_2 = properties.getGroup_2();

        MemCacheTable hashMap = MemCacheTable.getInstance();

        if (!interf_1.equalsIgnoreCase("null") && !group_1.equalsIgnoreCase("null")) {
            hashMap.addTable(new RoutingTable( netWorkAddress_1,mask_1,defaultGetWay_1,interf_1,0));
            createThread(group_1);
        }

        if (!interf_2.equalsIgnoreCase("null") && !group_2.equalsIgnoreCase("null")) {
            hashMap.addTable(new RoutingTable(netWorkAddress_2,mask_2,defaultGetWay_2,interf_2,0));
            createThread(group_2);
        }

        new Thread (() -> {
            while (true) {
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    for (UUID uuid: hashMap.getAllKey()) {
                        RoutingTable table = hashMap.getTableByKey(uuid);
                        System.out.println(table);
                    }

                    sleep(5000);
                } catch (InterruptedException exception) {
                    System.err.println("Не удалось приостановить выполнение потока:\n" + exception.getMessage());
                    break;
                } catch (IOException exception) {
                    System.err.println("Не удалось очистить поток вывода:\n" + exception.getMessage());
                }
            }
        }).start();
    }

    private static void createThread (String address){
        new Thread (new Receiver(address)).start();
        new Thread (new Publisher(address)).start();
        System.out.println("Созданые потоки Publisher и Receiver: " + address);
    }
}
