create index IX_4F415CF1 on memo_Memo (resourcePrimKey, latest);
create index IX_80922CA3 on memo_Memo (resourcePrimKey, main);
create index IX_F3E82E9C on memo_Memo (resourcePrimKey, status);
create unique index IX_B0A47D12 on memo_Memo (resourcePrimKey, version);