package com.transfer.network;

public class Main {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0"; // Adresse multicast
        int port = 4446;
        String filePath = "E:\\projet\\progRes\\text.txt"; // Chemin vers le fichier à envoyer

        MulticastSender sender = new MulticastSender(multicastAddress, port);
        MulticastReceiver receiver = new MulticastReceiver(multicastAddress, port);

        // Lancer le réceptionnaire dans un nouveau thread
        new Thread(receiver::startReception).start();

        // Envoyer le fichier spécifié
        sender.sendFile(filePath);
    }
}
