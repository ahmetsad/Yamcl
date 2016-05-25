
package eu.usrv.yamcore.auxiliary;


import net.minecraft.entity.player.EntityPlayer;
import eu.usrv.yamcore.YAMCore;


/**
 * Various functions for/with Players (EntityPlayer)
 * 
 * @author Namikon
 * 
 */
public class PlayerHelper
{
  /**
   * Remove protection from the player
   * 
   * @param pEntityPlayer
   */
  public static void RemoveProtection( EntityPlayer pEntityPlayer )
  {
    RemoveProtection( pEntityPlayer, true );
  }

  /**
   * Actually GIVE protection to the player and notify the player
   * 
   * @param pEntityPlayer
   */
  public static void GiveProtection( EntityPlayer pEntityPlayer )
  {
    GiveProtection( pEntityPlayer, true );
  }

  /**
   * Remove protection from the player
   * 
   * @param pEntityPlayer
   */
  public static void RemoveProtection( EntityPlayer pEntityPlayer, boolean pNotifyPlayer )
  {
    try
    {
      pEntityPlayer.capabilities.disableDamage = false;
      pEntityPlayer.sendPlayerAbilities();
      if( pNotifyPlayer )
        PlayerChatHelper.SendNotifyWarning( pEntityPlayer, "Your magic bubble of protection fades..." );
    }
    catch( Exception e )
    {
      YAMCore.instance.getLogger().error( "RemoveProtection failed to Remove player's protection" );
      YAMCore.instance.getLogger().DumpStack( e );
    }
  }

  /**
   * Actually GIVE protection to the player
   * 
   * @param pEntityPlayer
   * @param pNotifyPlayer notify the player about the change
   */
  public static void GiveProtection( EntityPlayer pEntityPlayer, boolean pNotifyPlayer )
  {
    try
    {
      pEntityPlayer.capabilities.disableDamage = true;
      pEntityPlayer.sendPlayerAbilities();
      if( pNotifyPlayer )
        PlayerChatHelper.SendNotifyPositive( pEntityPlayer, "A magic bubble of protection appears..." );
    }
    catch( Exception e )
    {
      YAMCore.instance.getLogger().error( "RemoveProtection failed to give a player protection" );
      YAMCore.instance.getLogger().DumpStack( e );
    }
  }
}
