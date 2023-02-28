# MatchAndReplaceWebSockets
Burp extension to match and replace a within a WebSocket message

# Usage
1. Modify `MATCH_WITH` and `REPLACE_WITH` in `MatchAndReplaceWebSockets.java` to desired values (`MATCH_WITH` will accept RegEx)
2. Load extension in Burp

# Notes
- This extension will only perform the replacement in messages that have a `CLIENT_TO_SERVER` direction
