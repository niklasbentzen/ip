public class User {
    private Message[] inbox;
    private static int inboxLimit = 20;
    private int messageCount;

    public User() {
        inbox = new Message[inboxLimit];
        messageCount = 0;
    }

    public String addMessage(Message msg) {
        if (messageCount < inboxLimit) {
            inbox[messageCount] = msg;
            messageCount++;
            return "Message is added!";
        } else {
            return "Sorry, the inbox is full!";
        }
    }

    public boolean sendMessage(Message msg) {
        String reply = msg.getReceiver().addMessage(msg);
        return reply.equals("Message is added!");
    }

    public String readMessage() {
        if (messageCount > 0) {
            String read = inbox[0].getText();
            for (int i = 0; i < messageCount - 1; i++) {
                inbox[i] = inbox[i + 1];
            }
            messageCount--;
            return read;
        }
        else {
            return "There is no message to read!";
        }
    }
}
