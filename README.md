# Lag Generator

This is a simple, brute-force "lag" generator for Minecraft servers.

It is configured via game rules.

- lag_generator_enableLag, true or false (false by default)
- lag_generator_serverPreTickLag, integer value of lag (in milliseconds) that should be created in each server pre-tick (default 80)
- lag_generator_serverPostTickLag, integer value of lag (in milliseconds) that should be created in each server post-tick (default 80)
- lag_generator_entityTickLag, integer value of lag (in milliseconds) that should be created in each entity base tick (default 10)

Lag comes in three flavours:

- Server Pre-Tick lag is added with `Thread.sleep` at the start of each server tick (after the tick count has been incremented)
- Server Post-Tick lag is added with `Thread.sleep` at the end of each server tick (after the profiler has been popped)

Both of these types of lag statically decrease TPS.

- Entity tick lag is added with `Thread.sleep` in the `Entity::baseTick` method. 

This type of lag is cumulative depending on the number of loaded entities.
