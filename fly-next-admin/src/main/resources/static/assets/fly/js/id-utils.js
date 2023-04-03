
function guid() {
    return new Snowflake(1n, 1n, 0n).nextId();
}