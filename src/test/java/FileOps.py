# --** coding="UTF-8" **--
#
import os
import re
import sys

'''
批量修改文件夹下文件名称，文件命名:原文件名称+文件夹名称,第一级根据传入的目标文件夹名称命名
文件传参执行如下
cmd 执行 python G:\WorkCodeExample\src\test\java\FileOps.py G://WorkCodeExample//src//test//java//textfile 
命令说明：
python 固定根目录
G:\WorkCodeExample\src\test\java\FileOps.py 脚本
G://WorkCodeExample//src//test//java//textfile 目标文件夹路径
textfile 一级文件更新的名称
'''
class changeFilename:
    def __init__(self,sourcePath):
        self.path=sourcePath
        os.chdir(self.path)

    def rename(path,newName):
        oldpath = path
        pos1 = path.find('_num_')
        pos2 = path.find('_',pos1+5)
        # newpath = path[:pos1]+path[pos2:]
        newName=newName+".docx"
        os.rename(path,newName)  # 对文件进行重命名]

    def update(self,folderName):
        # fileList = os.listdir(r"./textfile")
        fileList=os.listdir(self.path)
        # # 输出此文件夹中包含的文件名称
        # print("原文件：" + str(fileList))
        # # 得到进程当前工作目录
        # currentpath = os.getcwd()
        # # 将当前工作目录修改为待修改文件夹的位置
        # os.chdir(self.path)
        # # 名称变量
        # # num = 1
        #TODO当前文件放前面，文件夹放后面
        sortFileList = []
        for fileName in fileList:
            if os.path.isdir(os.path.join(self.path, fileName)):
                sortFileList.append(FolderInfo(fileName, 1))
            if os.path.isfile(os.path.join(self.path, fileName)):
                sortFileList.append(FolderInfo(fileName, 5))#文件排前面防止递归路径错乱无法替换文件

        sortFileList.sort(key=lambda x: x.orderNo, reverse=True) #利用lambda表达式对单个属性进行排序
        # 遍历文件夹中所有文件
        for fileName in sortFileList:
            try:
                file_path = os.path.join(self.path, fileName.name)  # 获取绝对路径
                if os.path.isdir(file_path):  # 判断是否是文件夹
                    self.path=file_path
                    folderName=fileName.name#子文件夹名称
                    changeFilename.update(self,folderName)  # 如果是文件夹，就递归调用自己;
                else:
                    extension_name = os.path.splitext(file_path)  # 将文件的绝对路径中的后缀名分离出来
                    if extension_name[1] == '.docx':
                        changeFilename.rename(file_path,(extension_name[0]+folderName))
            except:
                continue

            # # # 切片获取文件扩展名,因为docx的长度为4，如果是doc格式，那么长度就为3,以此类推
            # if fileName[-4::] == 'docx':
            #     # 匹配文件名正则表达式
            #     pat = ".+\.(docx)"
            #     # 进行匹配
            #     pattern = re.findall(pat, fileName)
            #     #原文件名+部门
            #     oldName=(fileName.split('.')[0])+'第二事业部'
            #     print("新文件名:", oldName)
            #     # 文件重新命名
            #     os.rename(fileName, (oldName+'.docx'))
            #     # 改变编号，继续下一项
            #     # num = num + 1

        # print("***************************************")
        # # 改回程序运行前的工作目录
        # os.chdir(currentpath)
        # # 刷新
        # sys.stdin.flush()
        # # 输出修改后文件夹中包含的文件名称
        # print("旧文件：" + str(os.listdir(self.path)))


class FolderInfo(object):
    def __init__(self, name, orderNo):
        self.name = name
        self.orderNo = orderNo

    def __str__(self):
        return '(%s, %s)' % (self.name,  self.orderNo)

    __repr__ = __str__

if __name__ == "__main__":
    sourceFilePath = "G://WorkCodeExample//src//test//java//textfile"    # 目标路径
    rootFolderName ="textfile"#当前根目录文件夹名称
    changeFilename(sourceFilePath).update(rootFolderName)
