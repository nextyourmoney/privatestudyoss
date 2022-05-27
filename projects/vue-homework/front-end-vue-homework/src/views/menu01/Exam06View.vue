<template>
    <div class="card">
        <div class="card-header">Exam06View</div>
        <div class="card-body">
            <div class="d-flex container-fluid">
                <div>
                    <router-view></router-view>
                </div>
                <div class="d-flex flex-column container-fluid">
                    <router-view name="rv1" class="mb-3"></router-view>
                    <router-view name="rv2" class="mb-3"></router-view>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup></script>

<style scoped></style>
