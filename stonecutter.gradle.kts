plugins {
    id("dev.kikugie.stonecutter")
}
stonecutter active "1.21"

stonecutter registerChiseled tasks.register("chiseledBuildAndCollect", stonecutter.chiseled) {
    group = "project"
    ofTask("buildAndCollect")
}