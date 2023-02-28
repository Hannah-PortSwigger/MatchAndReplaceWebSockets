import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class MatchAndReplaceWebSockets implements BurpExtension
{
    private static final String MATCH_WITH = "TEST";
    private static final String REPLACE_WITH = "REPLACEMENT";

    @Override
    public void initialize(MontoyaApi api)
    {
        api.extension().setName("Match and replace WebSockets");

        api.websockets().registerWebSocketCreatedHandler(webSocketCreated -> webSocketCreated.webSocket().registerMessageHandler(new MyWebSocketMessageHandler(MATCH_WITH, REPLACE_WITH)));
    }
}
