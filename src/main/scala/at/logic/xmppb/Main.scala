package at.logic.xmppb

import at.logic.xmppb.commandHandler._

object Main{

  def main(args: Array[String]){

    if (args.length == 3) {
      val username = args(0)
      val password = args(1)
      val servername = args(2)
      
      val chatDB = new ChatDB(username, password, servername)
      
      val bot = new XMPPBot(chatDB, new Greet(), new Google(), new Umbrella())
      bot.start()
    }
    else {
      help()
    }

    def help() = print(
    """
      
    XMPPBot Usage Instructions
    ==========================
        
      sbt run <username> <password> <server>    
      
        example:
          sbt run someuser@gmail.com gmail-password-for-someuser GTalk
      
    """       
    )

  }
}