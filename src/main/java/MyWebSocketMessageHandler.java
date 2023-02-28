import burp.api.montoya.websocket.*;

import static burp.api.montoya.websocket.TextMessageAction.continueWith;

public class MyWebSocketMessageHandler implements MessageHandler
{
    private final String matchWith;
    private final String replaceWith;

    public MyWebSocketMessageHandler(String matchWith, String replaceWith)
    {
        this.matchWith = matchWith;
        this.replaceWith = replaceWith;
    }

    @Override
    public TextMessageAction handleTextMessage(TextMessage textMessage)
    {
        if (textMessage.direction() == Direction.CLIENT_TO_SERVER)
        {
            String newMessage = textMessage.payload().replaceAll(matchWith, replaceWith);

            return continueWith(newMessage);
        }

        return continueWith(textMessage);
    }

    @Override
    public BinaryMessageAction handleBinaryMessage(BinaryMessage binaryMessage)
    {
        return BinaryMessageAction.continueWith(binaryMessage);
    }
}
